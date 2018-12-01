package com.spotter.backend.templates;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spotter.backend.controllers.CompetitionController;
import com.spotter.backend.services.Crud;
import com.spotter.backend.services.Mapper;
import com.spotter.backend.utilities.GenericTemplate;
import spark.Request;

import java.sql.ResultSet;

public class CompetitionTemplate extends GenericTemplate {
    private Crud crud = new Crud();
    private Mapper mapper = new Mapper();
    private CompetitionController cc =

    @Override
    public String constructJson(String body, int idInDatabase) {
        return null;
    }

    @Override
    public String constructJson(ResultSet rs) {
        String json = "";
        try {
            json = mapper.mapCompetition(rs);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe);
        }
        return json;
    }

    @Override
    public int postData(String body) {
        return 0;
    }

    @Override
    public ResultSet getData(Request req) {
        return crud.getCompetition(req.params("id"));
    }

}
