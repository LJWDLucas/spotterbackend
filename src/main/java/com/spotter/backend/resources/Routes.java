package com.spotter.backend.resources;

import com.google.gson.Gson;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.models.Competition;
import com.spotter.backend.services.DatabaseService;

import java.sql.ResultSet;
import java.util.ArrayList;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    public Routes() {

        // *-*-*-ALL GETTERS-*-*-* \\
        get("/competition/:id", (req, res) -> {
            CompetitionController competitionController = new CompetitionController();
            ResultSet rs = DatabaseService.get("SELECT * FROM competitions WHERE id = " + req.params(":id"));
            Competition c = competitionController.createCompetition(rs);
            Gson g = new Gson();
            res.type("application/json");
            return g.toJson(c);
        });

        get("/competition/:id/comments", (req, res) ->
                "TO DO " + req.params(":id") + " probably has no comments anyway."
        );

        get("/competitions", (req, res) -> {
            CompetitionController competitionController = new CompetitionController();
            ResultSet rs = DatabaseService.get("SELECT * FROM competitions");
            ArrayList<Competition> cList = competitionController.createCompetitionList(rs);
            Gson g = new Gson();
            res.type("application/json");
            return g.toJson(cList);
        });

        // *-*-*-ALL POSTS-*-*-* \\
        post("/math", (req, res) -> {
            System.out.println("yay");

            return "joi";
        });

        // *-*-*-ALL PUTS-*-*-* \\
    }
}
