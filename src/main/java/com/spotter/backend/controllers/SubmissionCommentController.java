package com.spotter.backend.controllers;

import com.spotter.backend.templates.GenericTemplate;
import com.spotter.backend.templates.SubmissionCommentTemplate;
import spark.Request;

public class SubmissionCommentController implements PostController {
    private GenericTemplate template = new SubmissionCommentTemplate();

    public String retrieveOne(Request request) {
        return template.retrieveFromDatabase(request);
    }

    public String retrieveAll() {
        return template.retrieveAllFromDatabase();
    }

    public String post(String body) {
        return template.addToDatabase(body);
    }

    public String delete(Request request) {
        return template.deleteFromDatabase(request);
    }

    public String update(String body) {
        return template.updateInDatabase(body);
    }

    public String retrieveAll(Request request) {
        return template.retrieveAllFromDataBaseById(request);
    }
}
