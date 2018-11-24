package com.spotter.backend.resources;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Imgur;
import com.spotter.backend.services.Calls;
import com.spotter.backend.services.DatabaseService;
import com.spotter.backend.services.Mapper;
import org.apache.http.HttpResponse;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {
    private Mapper mapper = new Mapper();

    public Routes() {
        // *-*-*-ALL GETTERS-*-*-* \\
        get("/competition/:id", (req, res) -> {
            CompetitionController competitionController = new CompetitionController();
            ResultSet rs = DatabaseService.get("SELECT * FROM competitions WHERE id = " + req.params(":id"));
//            Competition c = competitionController.createCompetition(rs);
            String s = mapper.getObjectMapper().writeValueAsString(rs);
            res.type("application/json");
            return s;
        });

        get("/competition/:id/comments", (req, res) ->
                "TO DO " + req.params(":id") + " probably has no comments anyway."
        );

        get("/competitions", (req, res) -> {
            CompetitionController competitionController = new CompetitionController();
            ResultSet rs = DatabaseService.get("SELECT * FROM competitions");
            ArrayList<Competition> cList = competitionController.createCompetitionList(rs);
            String s = mapper.getObjectMapper().writeValueAsString(cList);
            res.type("application/json");
            return s;
        });

        // *-*-*-ALL POSTS-*-*-* \\
        post("/math", (req, res) -> {
            System.out.println("yay");

            return "joi";
        });

        post("submit", (req, res) -> {
            res.type("application/json");
            Map<String, String> map = new HashMap<>();
            map.put("image", mapper.getPropertyValueAsString(req.body(), "data"));
            String userId = mapper.getPropertyValueAsString(req.body(), "userId");
            String competitionId = mapper.getPropertyValueAsString(req.body(), "competitionId");
            Calls c = new Calls();
            String s = c.postToImgUr(mapper.getObjectMapper().writeValueAsString(map));
            JsonNode jsonNode = mapper.getObjectMapper().readTree(s);
            JsonNode dataNode = jsonNode.get("data");
            String deleteHash = dataNode.get("deletehash").asText();
            String imgurId = dataNode.get("id").asText();
            String link = dataNode.get("link").asText();
            map.clear();
            map.put("link", "\""+link+"\"");
            map.put("deleteHash", "\""+deleteHash+"\"");
            map.put("imgurId", "\""+imgurId+"\"");
            map.put("userId", userId);
            map.put("competitionId", competitionId);
            int id = DatabaseService.post(
                    "INSERT INTO submissions (" + map.entrySet().stream().map(e -> e.getKey()).collect(joining(","))+ ") " +
                            "VALUES(" + map.entrySet().stream().map(e -> e.getValue()).collect(joining(",")) + ")");
            Imgur imgur = new Imgur.Builder()
                    .withDbId(id)
                    .withDeleteHash(deleteHash)
                    .withImgUrId(imgurId)
                    .withImgUrLink(link)
                    .build();

            return mapper.getObjectMapper().writeValueAsString(imgur);
        });

        // *-*-*-ALL PUTS-*-*-* \\


    }
}
