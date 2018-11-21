package com.spotter.backend.services;

import java.sql.*;

public class DatabaseService {
        private static Connection connect = null;

        public static Connection getConnection() {
            if (connect != null) {
                return connect;
            }
            try {
                String url = "jdbc:sqlite:/Users/dannylucas/Spotter.db";
                connect = DriverManager.getConnection(url);
                System.out.println("it worked");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connect;
        }

    /**
     * Default get method.
     * @param query
     * @return
     * @throws SQLException
     */
    public static ResultSet get(String query) {
            ResultSet rs = null;
            try {
                PreparedStatement st = DatabaseService.getConnection().prepareStatement(query);
                st.execute();
                rs = st.getResultSet();
            } catch (SQLException e) {
                // System.out.println(e.getMessage());
                System.out.println("Get is going wrong!");
            }
            return rs;
        }
}
