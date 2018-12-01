package com.spotter.backend.services;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.controllers.SubmissionController;
import com.spotter.backend.utilities.Mapper;

import static spark.Spark.*;

public class Routes {
    private Mapper mapper = new Mapper();
    private CompetitionController cC = new CompetitionController();
    private SubmissionController sC = new SubmissionController();
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

        get("/competition/:id/submissions", (req, res) -> sC.retrieveAll(req));

        /**
         * Currently not implemented.
         */
        get("/competition/:id/submission/:submissionId", (req, res) -> sC.retrieveOne(req));

//        get("competition/:competitionId/submission/:submissionId/comments", (req, res) -> mapper.getAllCompetitionSubmissionComments());

        // *-*-*-ALL POSTS-*-*-* \\
        post("/competition", (req, res) -> cC.post(req.body()));

//        post("/competition/comment", (req, res) -> mapper.postComment(req.body(), "competitionComments", "competitionId"));
//

        /**
         * Note that :id is ignored. The body should contain all relevant information.
         */
        post("/competition/:id/submission", (req, res) -> sC.post(req.body()));

        // *-*-*-ALL PUTS-*-*-* \\
        put("/competition", (req, res) -> cC.update(req.body()));

//        put("/competition/comment", (req, res) -> mapper.updateComment(req.body(), "Competition"));
//
//        put("/submission/comment", (req, res) -> mapper.updateComment(req.body(), "Submission"));


        // *-*-*-ALL DELETES-*-*-* \\

        delete("/competition/:id", (req, res) -> cC.delete(req));

        /**
         * Note that :id is ignored.
         */
        delete("/competition/:id/submission/:submissionId", (req, res) -> sC.delete(req));
    }
}
