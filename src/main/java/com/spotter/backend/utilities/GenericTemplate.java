package com.spotter.backend.utilities;

import spark.Request;

import java.sql.ResultSet;
import java.util.HashMap;

public abstract class GenericTemplate {

    public final String retrieveFromDatabase(Request req) {
        ResultSet rs = getData(req);
        String json = constructJson(rs);
        return json;
    }

    public final String addToDatabase(String body) {
        int idInDatabase = postData(body);
        String json = constructJson(body, idInDatabase);
        return json;
    }

    public abstract ResultSet getData(Request req);
    public abstract String constructJson(String body, int idInDatabase);
    public abstract String constructJson(ResultSet rs);
    public abstract int postData(String body);
}
