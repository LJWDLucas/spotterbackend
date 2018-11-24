package com.spotter.backend.controllers;

import com.spotter.backend.models.Competition;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionControllerTest {

    @Test
    public void testCreateCompetition() throws SQLException {
        ResultSet rs = Mockito.mock(ResultSet.class);
        Mockito.when(rs.next()).thenReturn(false);
        Mockito.when(rs.getInt("id")).thenReturn(1);
        Mockito.when(rs.getString("description")).thenReturn("This is a test.");
        Mockito.when(rs.getInt("enabled")).thenReturn(0);
        Mockito.when(rs.getInt("userId")).thenReturn(1);

        Competition c = new Competition(1, "This is a test.", 0, 1);

        CompetitionController cc = new CompetitionController();
        Competition testC = cc.createCompetition(rs);
        Assert.assertEquals(c, testC);
    }
}
