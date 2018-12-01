package com.spotter.backend.templates;

import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Post;
import com.spotter.backend.services.CrudCompetition;
import spark.Request;

import java.util.ArrayList;

public class CompetitionTemplate extends GenericTemplate {
    private CrudCompetition crud = new CrudCompetition();

    @Override
    public Competition postData(String body) {
        return crud.post(body);
    }

    @Override
    public Competition getData(Request req) {
        return crud.get(Integer.parseInt(req.params("id")));
    }

    @Override
    public ArrayList<Post> getAllData() {
        return crud.getAll();
    }

    @Override
    public Competition updateData(String body) {
        return crud.update(body);
    }

    @Override
    protected boolean deleteData(Request req) {
        return crud.delete(Integer.parseInt(req.params("id")));
    }

    /**
     * No implementation required.
     * @return null
     */
    @Override
    protected ArrayList<Post> getAllDataById(Request req) {
        return null;
    }
}
