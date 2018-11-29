package com.spotter.backend.resources;

import com.spotter.backend.services.DatabaseService;

import java.sql.ResultSet;

public class Crud {

    public ResultSet getCompetition(String id) {
        return DatabaseService.get("SELECT * FROM competitions WHERE id = " + id);
    }

    public ResultSet getAllCompetitions() {
        return DatabaseService.get("SELECT * FROM competitions");
    }
}
