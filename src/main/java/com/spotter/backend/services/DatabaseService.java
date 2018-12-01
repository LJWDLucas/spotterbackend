package com.spotter.backend.services;

import java.io.IOException;
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
//    /**
//     * Default get method.
//     * @param query
//     * @return
//     * @throws SQLException
//     */
//    public static ResultSet get(String query) {
//            ResultSet rs = null;
//            try {
//                PreparedStatement st = DatabaseService.getConnection().prepareStatement(query);
//                st.execute();
//                rs = st.getResultSet();
//            } catch (SQLException e) {
//                System.out.println("Get is going wrong!");
//            }
//            return rs;
//        }
//
//    /**
//     * Insert a single entry into the database. Returns the id of the record.
//     * @param query
//     * @return
//     */
//    public static int post(String query) {
//        int id = -1;
//        try {
//            PreparedStatement st = DatabaseService.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//            st.execute();
//            ResultSet rs = st.getGeneratedKeys();
//            while(rs.next()) {
//                id = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            System.out.println("Post is going wrong!");
//        }
//        return id;
//    }
//
//    // deprecated
//    public static int update(String query, String id, String comment) {
//        try {
//            PreparedStatement st = DatabaseService.getConnection().prepareStatement(query);
//            st.setString(1, comment);
//            st.setInt(2, Integer.parseInt(id));
//            return st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Update is going wrong!");
//        }
//        return -1;
//    }

//    public int update(PreparedStatement st) {
//        try {
//            return st.executeUpdate();
//        } catch (SQLException se) {
//            System.out.println(se);
//        }
//        return -1;
//    }

