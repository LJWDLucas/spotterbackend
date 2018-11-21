package com.spotter.backend.controllers;

import com.spotter.backend.models.Competition;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CompetitionController {
    private ArrayList<Competition> cList = new ArrayList<>();

    public Competition createCompetition(ResultSet rs) {
        Competition competition = null;
        try {
            competition = new Competition(
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getInt("enabled")
            );
        } catch(Exception e) {
            System.out.println("Couldn't create a competition object.");
        }
        return competition;
    }

    public ArrayList createCompetitionList(ResultSet rs) {
        try {
            while(rs.next()) {
                Competition competition = new Competition(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("enabled")
                );
                cList.add(competition);
            }
        } catch(Exception e) {
            System.out.println("Couldn't create a competition list.");
        }
        return cList;
    }
}
