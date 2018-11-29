package com.spotter.backend.services;

import java.sql.ResultSet;

public class Crud {
    private final String getCompetitionQuery = "SELECT * FROM competitions WHERE id = ";
    private final String getAllCompetitionsQuery = "SELECT * FROM competitions";
    private final String getCompetitonComments = "SELECT * FROM comments WHERE competitionId = ";

    public ResultSet getCompetition(String id) {
        return DatabaseService.get(getCompetitionQuery + id);
    }

    public ResultSet getAllCompetitions() {
        return DatabaseService.get(getAllCompetitionsQuery);
    }

    public ResultSet getCompetitionComments(String competitionId) {
        return DatabaseService.get(getCompetitonComments + competitionId);
    }
}
