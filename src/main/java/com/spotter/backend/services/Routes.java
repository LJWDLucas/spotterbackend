package com.spotter.backend.services;
import com.spotter.backend.services.Mapper;
import static spark.Spark.*;

public class Routes {
    private Mapper mapper = new Mapper();

    public Routes() {
        // Removes the need to set content type for each response.
        before((req, res) -> {
            res.type("application/json");
        });

        // *-*-*-ALL GETTERS-*-*-* \\
        get("/competition/:id", (req, res) -> mapper.getCompetition(req.params(":id")));

        get("/competition/:id/comments", (req, res) ->
                "TO DO " + req.params(":id") + " probably has no comments anyway."
        );

        get("/competitions", (req, res) -> mapper.getAllCompetitions());

        // *-*-*-ALL POSTS-*-*-* \\
        post("competition/:id/comment", (req, res) -> mapper.postCompetitionComment(req.params(":id")));

        post("submit", (req, res) -> mapper.postImageToImgUr(req.body()));

        // *-*-*-ALL PUTS-*-*-* \\


    }
}
