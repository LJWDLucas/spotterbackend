package com.spotter.backend.services;
import com.spotter.backend.controllers.*;

import static spark.Spark.*;

public class Routes {
    private CompetitionController cC = new CompetitionController();
    private SubmissionController sC = new SubmissionController();
    private CompetitionCommentController cCC = new CompetitionCommentController();
    private SubmissionCommentController sCC = new SubmissionCommentController();
    private LikeController likeController = new LikeController();

    public Routes() {
        // Removes the need to set content type for each response.
        before((req, res) -> {
            res.type("application/json");
        });

        // Routes for Competitions \\
        get("/competitions", (req, res) -> cC.retrieveAll());

        get("/competition/:id", (req, res) -> cC.retrieveOne(req));

        post("/competition", (req, res) -> cC.post(req.body()));

        put("/competition", (req, res) -> cC.update(req.body()));

        delete("/competition/:id", (req, res) -> cC.delete(req));

        // Routes for Submissions \\
        get("/competition/:id/submissions", (req, res) -> sC.retrieveAll(req));

        post("/competition/submission", (req, res) -> sC.post(req.body()));

        delete("/competition/submissions/:id", (req, res) -> sC.delete(req));

        // Routes for Comments on Competitions \\
        get("/competition/:id/comments", (req, res) -> cCC.retrieveAll(req));

        post("/competition/comment", (req, res) -> cCC.post(req.body()));

        put("/competition/comment", (req, res) -> cCC.update(req.body()));

        delete("/competition/comment/:id", (req, res) -> cCC.delete(req));

        // Routes for Comments on Submissions \\
        get("/competition/:id/submission/:submissionId/comments", (req, res) -> sCC.retrieveAll(req));

        post("/competition/submission/comment", (req, res) -> sCC.post(req.body()));

        put("/competition/submission/comment", (req, res) -> sCC.update(req.body()));

        delete("/competition/submission/comment/:id", (req, res) -> sCC.delete(req));

        // Routes for Likes \\
        get("/like/:userId/:type/:typeId", (req, res) -> likeController.getLike(req));

        get("/total/:type/:typeId", (req, res) -> likeController.getTotalLikes(req));

        post("/like/:type", (req, res) -> likeController.postLike(req));

        put("/like/:type", (req, res) -> likeController.updateLike(req));
    }
}
