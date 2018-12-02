package com.spotter.backend.services;

import java.sql.*;

public class DatabaseService {
    private Connection connect = null;

    public Connection getConnection() {

        try {
            String url = "jdbc:sqlite:/Users/dannylucas/Spotter.db";
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connect;
    }
}