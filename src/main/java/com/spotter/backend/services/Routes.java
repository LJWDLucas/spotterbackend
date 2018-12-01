package com.spotter.backend.services;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.templates.CompetitionTemplate;
import com.spotter.backend.templates.GenericTemplate;
import com.spotter.backend.utilities.Mapper;

import static spark.Spark.*;

public class Routes {
    private Mapper mapper = new Mapper();
    private CompetitionController cC = new CompetitionController();
    /**
     * Contains all routes.
     */
    public Routes() {
        // Removes the need to set content type for each response.
        before((req, res) -> {
            res.type("application/json");
        });

        // *-*-*-ALL GETTERS-*-*-* \\

        get("/competitions", (req, res) -> cC.retrieveAll());

        get("/competition/:id", (req, res) -> cC.retrieveOne(req));

//        get("/competition/:id/comments", (req, res) -> mapper.getAllCompetitionComments(req.params(":id")));
//
//        get("/competition/:id/submissions", (req, res) -> mapper.getAllCompetitionSubmissions(req.params(":id")));

//        get("competition/:competitionId/submission/:submissionId/comments", (req, res) -> mapper.getAllCompetitionSubmissionComments());

        // *-*-*-ALL POSTS-*-*-* \\
        post("/competition", (req, res) -> cC.post(req.body()));

//        post("/competition/comment", (req, res) -> mapper.postComment(req.body(), "competitionComments", "competitionId"));
//
//        post("/submission/submit", (req, res) -> mapper.postImageToImgUr(req.body()));

        // *-*-*-ALL PUTS-*-*-* \\
        put("/competition", (req, res) -> cC.update(req.body()));

//        put("/competition/comment", (req, res) -> mapper.updateComment(req.body(), "Competition"));
//
//        put("/submission/comment", (req, res) -> mapper.updateComment(req.body(), "Submission"));


        // *-*-*-ALL DELETES-*-*-* \\

        delete("/competition/:id", (req, res) -> cC.delete(req));
    }
}
