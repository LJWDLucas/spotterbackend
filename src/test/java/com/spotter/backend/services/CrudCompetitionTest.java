package com.spotter.backend.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudCompetitionTest {

    @Mock
    private ResultSet rs;

    @Mock
    private DatabaseService db;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private Connection c;

    private Crud crud = new CrudCompetition();


    @BeforeEach
    public void setUp() throws Exception {
        Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
        Mockito.when(db.getConnection()).thenReturn(c);
    }

    @Test
    public void testGetCompetition(){

    }

}
