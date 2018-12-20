package com.spotter.backend.templates;

import com.spotter.backend.models.Post;
import com.spotter.backend.services.CrudSubmissionComment;
import spark.Request;

import java.util.ArrayList;

public class SubmissionCommentTemplate extends GenericTemplate {
    private CrudSubmissionComment crud = new CrudSubmissionComment();

    @Override
    protected ArrayList<Post> getAllData() {
        return null;
    }

    @Override
    protected ArrayList<Post> getAllDataById(Request req) {
        return crud.getAllById(Integer.parseInt(req.params( "submissionId")));
    }

    @Override
    protected Post getData(Request req) {
        return null;
    }

    @Override
    protected Post postData(String body) {
        return crud.post(body);
    }

    @Override
    protected Post updateData(String body) {
        return crud.update(body);
    }

    @Override
    protected boolean deleteData(Request req) {
        return crud.delete(Integer.parseInt(req.params("id")));
    }
}
