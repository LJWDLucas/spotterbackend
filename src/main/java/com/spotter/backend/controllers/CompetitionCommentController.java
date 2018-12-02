package com.spotter.backend.controllers;

import com.spotter.backend.templates.CompetitionCommentTemplate;
import com.spotter.backend.templates.GenericTemplate;
import spark.Request;

public class CompetitionCommentController implements PostController {
    private GenericTemplate template = new CompetitionCommentTemplate();

    @Override
    public String retrieveOne(Request request) {
        return null;
    }

    @Override
    public String retrieveAll() {
        return null;
    }

    @Override
    public String post(String body) {
        return template.addToDatabase(body);
    }

    @Override
    public String delete(Request request) {
        return template.deleteFromDatabase(request);
    }

    @Override
    public String update(String body) {
        return template.updateInDatabase(body);
    }

    @Override
    public String retrieveAll(Request request) {
        return template.retrieveAllFromDataBaseById(request);
    }
}
