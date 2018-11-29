package com.spotter.backend.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.controllers.PostController;
import com.spotter.backend.factories.PostFactory;
import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Imgur;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Mapper {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Crud crud = new Crud();

    public Mapper() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String getPropertyValueAsString(String body, String property) throws IOException {
        JsonNode j = objectMapper.readTree(body);
        return j.get(property).asText();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    //TO DO: error handling
    public String getCompetition(String id) throws JsonProcessingException {
        ResultSet rs = crud.getCompetition(id);
        return objectMapper.writeValueAsString(rs);
    }

    public String getAllCompetitions() throws JsonProcessingException {
        ResultSet rs = crud.getAllCompetitions();
        CompetitionController competitionController = new CompetitionController();
        ArrayList<Competition> cList = competitionController.createCompetitionList(rs);
        return objectMapper.writeValueAsString(cList);
    }

    public String getAllCompetitionComments(String id) throws JsonProcessingException {
        ResultSet rs = crud.getCompetitionComments(id);
        PostController postController = new PostController();
        ArrayList<Competition> cList = postController.createPostList(rs, "Comment", "Competition");
        return objectMapper.writeValueAsString(cList);
    }

    public String postCompetitionComment(String compeitionId) {
        return "s";
    };

    public String postImageToImgUr(String body) throws Exception {
        // Setup to post to Imgur. We put it into a hashmap because Jackson has an easier time turning hashmaps into json strings.
        Map<String, String> map = new HashMap<>();
        map.put("image", getPropertyValueAsString(body,"data"));

        Calls c = new Calls();
        String s = c.postToImgUr(objectMapper.writeValueAsString(map));

        // Get specific data from the Json returned by Imgur.
        JsonNode jsonNode = objectMapper.readTree(s);
        JsonNode dataNode = jsonNode.get("data");
        String deleteHash = dataNode.get("deletehash").asText();
        String imgurId = dataNode.get("id").asText();
        String link = dataNode.get("link").asText();

        String userId = getPropertyValueAsString(body, "userId");
        String competitionId = getPropertyValueAsString(body, "competitionId");

        // Setup for query to post into database.
        map.clear();
        map.put("link", "\""+link+"\"");
        map.put("deleteHash", "\""+deleteHash+"\"");
        map.put("imgurId", "\""+imgurId+"\"");
        map.put("userId", userId);
        map.put("competitionId", competitionId);
        int id = DatabaseService.post(
                "INSERT INTO submissions (" + map.entrySet().stream().map(e -> e.getKey()).collect(joining(","))+ ") " +
                        "VALUES(" + map.entrySet().stream().map(e -> e.getValue()).collect(joining(",")) + ")");

        // Build imgur class for parsing to Json.
        Imgur imgur = new Imgur.Builder()
                .withDbId(id)
                .withDeleteHash(deleteHash)
                .withImgUrId(imgurId)
                .withImgUrLink(link)
                .build();

        return objectMapper.writeValueAsString(imgur);
    }
}
