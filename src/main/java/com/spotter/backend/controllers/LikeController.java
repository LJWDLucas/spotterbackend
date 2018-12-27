package com.spotter.backend.controllers;

import com.spotter.backend.models.Like;
import com.spotter.backend.services.CrudLike;
import com.spotter.backend.utilities.JsonBuilder;
import spark.Request;

public class LikeController {
    private CrudLike crud = new CrudLike();
    private JsonBuilder builder = new JsonBuilder();

    public String getLike(Request req) {
        Like like = crud.getLike(req);
        return builder.mapToJson(like);
    }

    public String getTotalLikes(Request req) {
        int i = crud.getTotalLikes(req);
        return builder.valueToJson(i, "total");
    }

    public String postLike(Request req) {
        Like like = crud.createLike(req);
        return builder.mapToJson(like);
    }

    public String updateLike(Request req) {
        Like like = crud.updateLike(req);
        return builder.mapToJson(like);
    }
}
