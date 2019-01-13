package com.spotter.backend.services;

import com.spotter.backend.utilities.Extractor;
import spark.Request;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudLogin {
    private DatabaseService db = new DatabaseService();

    private String fetchUser = "SELECT email, password FROM users WHERE email = ?";
    private String createUser = "INSERT INTO users(email, password) VALUES(?, ?)";

    public boolean loginUser(Request req) {
        boolean isValid = false;

        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(fetchUser)
        ) {
            String email = Extractor.getInstance().getPropertyValueAsString(req.body(), "email");
            String password = Extractor.getInstance().getPropertyValueAsString(req.body(), "password");
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery())   {
                if(rs.next()) {
                    String p = rs.getString("password");
                    if (p.matches(password)) {
                        isValid = true;
                    }
                } else {
                    return isValid;
                }
            }
        } catch (SQLException se) {
            System.out.println(se);
        } catch (IOException io) {
            System.out.println(io);
        }

        return isValid;
    }

    public int createUser(String email, String password) {
        int result = -1;

        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(fetchUser)
        ) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery())   {
                if(rs.next()) {
                  result = -1;
                  return result;
                }
            }
        } catch (SQLException se) {
            System.out.println(se);
        }


        try (
                Connection con2 = db.getConnection();
                PreparedStatement ps2 = con2.prepareStatement(createUser, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            ps2.setString(1, email);
            ps2.setString(2, password);
            ps2.executeUpdate();
            try (ResultSet rs2 = ps2.getGeneratedKeys())   {
                if(rs2.next()) {
                    return rs2.getInt(1);
                }
            }
        }catch (SQLException se) {
            System.out.println(se);
        }

        return result;
    }

}
