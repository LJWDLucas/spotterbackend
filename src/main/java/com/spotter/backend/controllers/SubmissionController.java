package com.spotter.backend.controllers;

import com.spotter.backend.templates.GenericTemplate;
import com.spotter.backend.templates.SubmissionTemplate;
import spark.Request;

public class SubmissionController implements PostController {
    private GenericTemplate sT = new SubmissionTemplate();

    /**
     * No implementation required.
     * @param request
     * @return
     */
    @Override
    public String retrieveOne(Request request) {
        return null;
    }

    /**
     * No implementation required.
     * @return null
     */
    @Override
    public String retrieveAll() {
        return null;
    }

    public String retrieveAll(Request request) {
        return sT.retrieveAllFromDataBaseById(request);
    }

    @Override
    public String post(String body) {
        return sT.addToDatabase(body);
    }

    @Override
    public String delete(Request request) {
        return sT.deleteFromDatabase(request);
    }

    @Override
    public String update(String body) {
        return sT.updateInDatabase(body);
    }
}
