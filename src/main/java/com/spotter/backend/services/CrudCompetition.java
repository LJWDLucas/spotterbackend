package com.spotter.backend.services;

import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Post;
import com.spotter.backend.utilities.Extractor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudCompetition implements Crud {
    private final String getCompetitionQuery = "SELECT * FROM competitions WHERE id = ?";
    private final String getAllCompetitionsQuery = "SELECT * FROM competitions";
    private final String updateCompetitionQuery = "UPDATE competitions SET description = ?, enabled = ?, name = ? WHERE id = ?";
    private final String deleteCompetitionQuery = "DELETE FROM competitions WHERE id = ?";
    private final String postCompetitionQuery = "INSERT INTO competitions(description, enabled, userId, name, numberOfLikes) VALUES(?, ?, ?, ? ,?)";
    private DatabaseService db = new DatabaseService();
    private Extractor extractor = new Extractor();

    public Competition get(int id) {
        Competition competition = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(getCompetitionQuery)
            ) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery())   {
                    if(rs.next()) {
                        competition = new Competition(
                                rs.getInt("id"),
                                rs.getInt("userId"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getInt("enabled") == 1,
                                rs.getInt("numberOfLikes")
                        );
                    }
                }
            } catch (SQLException se) {
                // do stuff
            }
        return competition;
    }

    public ArrayList<Post> getAll() {
        ArrayList<Post> cList = new ArrayList<>();
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(getAllCompetitionsQuery)
            )   {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        Competition competition = new Competition(
                                rs.getInt("id"),
                                rs.getInt("userId"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getInt("enabled") == 1,
                                rs.getInt("numberOfLikes")

                        );
                        cList.add(competition);
                    }
                }
            } catch (SQLException se) {
                // do stuff
            }
        return cList;
    }

    public Competition post(String body) {
        Competition competition = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(postCompetitionQuery, PreparedStatement.RETURN_GENERATED_KEYS)
            )   {
                    competition = extractor.extractCompetition(body);
                    ps.setString(1, competition.getText());
                    ps.setInt(2, competition.isEnabled() ? 1 : 0);
                    ps.setInt(3, competition.getUserId());
                    ps.setString(4, competition.getName());
                    ps.setInt(5, 0);
                    ps.executeUpdate();
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        while (rs.next()) {
                            competition.setId(rs.getInt(1));
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } catch (SQLException sql) {
                    //  to do
                    System.out.println(sql);
                } catch (IOException io) {
                    //  to do
                    System.out.println(io);
                }

        return competition;
    }


    public Competition update(String body) {
        Competition competition = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(updateCompetitionQuery)
            )   {
                    competition = extractor.extractCompetition(body);
                    competition.setId(Integer.parseInt(extractor.getPropertyValueAsString(body, "competitionId")));
                    ps.setString(1, competition.getText());
                    ps.setInt(2, competition.isEnabled() ? 1 : 0);
                    ps.setString(3, competition.getName());
                    ps.setInt(4, competition.getId());
                    ps.executeUpdate();
                } catch (SQLException sql) {

                } catch (IOException io) {

                }
        return competition;
    }

    public boolean delete(int id) {
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(deleteCompetitionQuery)
            )   {
                    ps.setInt(1, id);
                    // Returns false whether successful or not. Re do later.
                    return !ps.execute();
                } catch (SQLException se) {
                    return false;
                }
    }
}
