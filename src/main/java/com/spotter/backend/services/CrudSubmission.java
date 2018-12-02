package com.spotter.backend.services;

import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudSubmission implements Crud {
    private final String getAllSubmissionsByIdQuery = "SELECT * FROM submissions WHERE competitionId = ?";
    private final String deleteSubmissionQuery = "DELETE FROM submissions WHERE id = ?";
    private final String postSubmissionQuery = "INSERT INTO submissions(competitionId, userId, imgurId, url, deleteHash, numberOfLikes, longitude, latitude) VALUES(?, ?, ?, ? ,?, ?, ?, ?)";
    private DatabaseService db = new DatabaseService();

    @Override
    public ArrayList<Post> getAllById(int id) {
        ArrayList<Post> sList = new ArrayList<>();
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(getAllSubmissionsByIdQuery)
        )   {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Submission submission = new Submission(
                            rs.getInt("id"),
                            rs.getInt("userId"),
                            rs.getInt("competitionId"),
                            rs.getString("imgurId"),
                            rs.getString("description"),
                            rs.getInt("numberOfLikes"),
                            rs.getString("url"),
                            rs.getString("deleteHash"),
                            rs.getString("longitude"),
                            rs.getString("latitude")
                    );
                    sList.add(submission);
                }
            }
        } catch (SQLException se) {
            // do stuff
        }
        return sList;
    }

    @Override
    public Submission post(Post post) {
        Submission sub = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(postSubmissionQuery, PreparedStatement.RETURN_GENERATED_KEYS)
        )   {
                sub = (Submission) post;

                ps.setInt(1, sub.getCompetitionId());
                ps.setInt(2, sub.getUserId());
                ps.setString(3, sub.getImgurId());
                ps.setString(4, sub.getUrl());
                ps.setString(5, sub.getDeleteHash());
                ps.setInt(6, sub.getNumberOfLikes());
                ps.setString(7, sub.getLongitude());
                ps.setString(8, sub.getLatitude());

                ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    sub.setId(rs.getInt(1));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (SQLException sql) {
            //  to do
            System.out.println(sql);
        }

        return sub;
    }

    @Override
    public boolean delete(int id) {
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(deleteSubmissionQuery)
        )   {
            ps.setInt(1, id);
            // Returns false whether successful or not. Re do later.
            return !ps.execute();
        } catch (SQLException se) {
            return false;
        }
    }


    /**
     * No implementation required.
     * @param body
     * @return
     */
    @Override
    public Post update(String body) {
        return null;
    }

    /**
     * No implementation required.
     * @param id
     * @return
     */
    @Override
    public Post get(int id) {
        return null;
    }

    /**
     * No implementation required.
     * @return
     */
    @Override
    public ArrayList<?> getAll() {
        return null;
    }

    @Override
    public Post post(String body) {
        return null;
    }
}
