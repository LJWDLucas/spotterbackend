package com.spotter.backend.services;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.utilities.Extractor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudSubmissionComment implements Crud {
    private final String getAllCommentsForSubmissionQuery = "SELECT * FROM submissionComments WHERE competitionId = ?";
    private final String updateSubmissionCommentQuery = "UPDATE submissionComments SET comment = ? WHERE id = ?";
    private final String deleteSubmissionCommentQuery = "DELETE FROM submissionComments WHERE id = ?";
    private final String postSubmissionCommentQuery = "INSERT INTO submissionComments(userId, submissionId, comment) VALUES(?, ?, ?)";
    private DatabaseService db = new DatabaseService();

    @Override
    public Post get(int id) {
        return null;
    }

    @Override
    public Post post(Post post) {
        return null;
    }

    @Override
    public ArrayList<Post> getAll() {
        return null;
    }

    @Override
    public ArrayList<Post> getAllById(int id) {
        ArrayList<Post> cList = new ArrayList<>();
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(getAllCommentsForSubmissionQuery)
        )   {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Comment comment = new Comment(
                            rs.getInt("id"),
                            rs.getInt("userId"),
                            rs.getString("text"),
                            rs.getInt("submissionId")
                    );
                    cList.add(comment);
                }
            }
        } catch (SQLException se) {
            // do stuff
            System.out.println(se);
        }
        return cList;
    }

    @Override
    public Post post(String body) {
        Comment comment = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(postSubmissionCommentQuery, PreparedStatement.RETURN_GENERATED_KEYS)
        )   {
            comment = Extractor.getInstance().extractComment(body);
            ps.setInt(1, comment.getUserId());
            ps.setInt(2, comment.getFlexId());
            ps.setString(3, comment.getText());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                while (rs.next()) {
                    comment.setId(rs.getInt(1));
                    comment.setNumberOfLikes(0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (SQLException sql) {
            //  to do
            System.out.println(sql);

            System.out.println(sql);
        } catch (IOException io) {
            //  to do
            System.out.println(io);
        }

        return comment;
    }

    @Override
    public boolean delete(int id) {
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(deleteSubmissionCommentQuery)
        )   {
            ps.setInt(1, id);
            // Returns false whether successful or not. Re do later.
            return !ps.execute();
        } catch (SQLException se) {
            return false;
        }
    }

    @Override
    public Post update(String body) {
        Comment comment = null;
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(updateSubmissionCommentQuery)
        )   {
            comment = Extractor.getInstance().extractComment(body);
            comment.setId(Integer.parseInt(Extractor.getInstance().getPropertyValueAsString(body, "commentId")));
            ps.setString(1, comment.getText());
            ps.setInt(2, comment.getId());
            ps.executeUpdate();
        } catch (SQLException sql) {

        } catch (IOException io) {

        }
        return comment;
    }
}
