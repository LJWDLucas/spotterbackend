package com.spotter.backend.controllers;

import com.spotter.backend.models.Competition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class CompetitionControllerTest {
    private CompetitionController cc = new CompetitionController();

//    @Test
//    public void testCreateCompetitions() throws SQLException {
//        ResultSet rs = Mockito.mock(ResultSet.class);
//        Mockito.when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
//        Mockito.when(rs.getInt("id")).thenReturn(1).thenReturn(1);
//        Mockito.when(rs.getString("description")).thenReturn("This is a test.").thenReturn("This is a test.");
//        Mockito.when(rs.getInt("enabled")).thenReturn(0).thenReturn(0);
//        Mockito.when(rs.getInt("userId")).thenReturn(1).thenReturn(1);
//        Mockito.when(rs.getInt("numberOfLikes")).thenReturn(0).thenReturn(1);
//
//        ArrayList<Competition> testC = cc.createCompetitionList(rs);
//        Assertions.assertEquals(2, testC.size());
//    }
}
