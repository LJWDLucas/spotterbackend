package com.spotter.backend.services;
import com.spotter.backend.templates.CompetitionTemplate;
import com.spotter.backend.utilities.GenericTemplate;

import static spark.Spark.*;
import static spark.route.HttpMethod.put;

public class Routes {
    private Mapper mapper = new Mapper();
    private GenericTemplate cTemplate = new CompetitionTemplate();
    /**
     * Contains all routes.
     */
    public Routes() {
        // Removes the need to set content type for each response.
        before((req, res) -> {
            res.type("application/json");
        });

        // *-*-*-ALL GETTERS-*-*-* \\
        get("/competition/:id", (req, res) -> cTemplate.retrieveFromDatabase(req));

        get("/competition/:id/comments", (req, res) -> mapper.getAllCompetitionComments(req.params(":id")));

        get("/competitions", (req, res) -> mapper.getAllCompetitions());

        get("competition/:id/submissions", (req, res) -> mapper.getAllCompetitionSubmissions(req.params(":id")));

//        get("competition/:competitionId/submission/:submissionId/comments", (req, res) -> mapper.getAllCompetitionSubmissionComments());

        // *-*-*-ALL POSTS-*-*-* \\
        post("/competition/comment", (req, res) -> mapper.postComment(req.body(), "competitionComments", "competitionId"));

        post("/submission/submit", (req, res) -> mapper.postImageToImgUr(req.body()));

        // *-*-*-ALL PUTS-*-*-* \\
        put("/competition/comment", (req, res) -> mapper.updateComment(req.body(), "Competition"));

        put("/submission/comment", (req, res) -> mapper.updateComment(req.body(), "Submission"));


        // *-*-*-ALL DELETES-*-*-* \\
    }
}