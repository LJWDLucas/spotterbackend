package com.spotter.backend.services;

import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Like;
import com.spotter.backend.utilities.Extractor;
import spark.Request;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CrudLike {
    private DatabaseService db = new DatabaseService();
    private HashMap<String, String> getLikeQueries = new HashMap<>();
    private HashMap<String, String> totalLikesQueries = new HashMap<>();
    private HashMap<String, String> createLikeQueries = new HashMap<>();
    private HashMap<String, String> updateLikeQueries = new HashMap<>();

    public CrudLike() {
        getLikeQueries.put("competition", "SELECT * FROM competitionLikes WHERE userId = ? AND competitionId = ?");
        getLikeQueries.put("competitionComment", "SELECT * FROM competitionCommentsLikes WHERE userId = ? AND competitionCommentId = ?");
        getLikeQueries.put("submission", "SELECT * FROM submissionLikes WHERE userId = ? AND submissionId = ?");
        getLikeQueries.put("submissionComment", "SELECT * FROM submissionCommentsLikes WHERE userId = ? AND submissionCommentId = ?");

        totalLikesQueries.put("competition", "SELECT COUNT(*) AS total FROM competitionLikes WHERE competitionId = ? AND likes = 1");
        totalLikesQueries.put("competitionComment", "SELECT COUNT(*) AS total FROM competitionCommentLikes WHERE competitionCommentId = ? AND likes = 1");
        totalLikesQueries.put("submission", "SELECT COUNT(*) AS total FROM submissionLikes WHERE submissionId = ? AND likes = 1");
        totalLikesQueries.put("submissionComment", "SELECT COUNT(*) AS total FROM submissionCommentsLikes WHERE submissionCommentId = ? AND likes = 1");

        createLikeQueries.put("competition", "INSERT INTO competitionLikes(userId, competitionId, likes) VALUES(?, ?, ?)");
        createLikeQueries.put("competitionComment", "INSERT INTO competitionCommentLikes(userId, competitionCommentId, likes) VALUES(?, ?, ?)");
        createLikeQueries.put("submission", "INSERT INTO submissionLikes(userId, submissionId, likes) VALUES(?, ?, ?)");
        createLikeQueries.put("submissionComment", "INSERT INTO submissionCommentsLikes(userId, submissionCommentId, likes) VALUES(?, ?, ?)");

        updateLikeQueries.put("competition", "UPDATE competitionLikes SET likes = ? WHERE userId = ? AND competitionId = ?");
        updateLikeQueries.put("competitionComment", "UPDATE competitionCommentLikes SET likes = ? WHERE userId = ? AND competitionCommentId = ?");
        updateLikeQueries.put("submission", "UPDATE submissionLikes SET likes = ? WHERE userId = ? AND submissionId = ?");
        updateLikeQueries.put("submissionComment", "UPDATE submissionCommentsLikes SET likes = ? WHERE userId = ? AND submissionCommentId = ?");
    }

    public Like getLike(Request req) {
        Like like = null;

        String query = getLikeQueries.get(req.params("type"));
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        ) {
            int userId = Integer.parseInt(req.params("userId"));
            int typeId = Integer.parseInt(req.params("typeId"));
            ps.setInt(1, userId);
            ps.setInt(2, typeId);

            try (ResultSet rs = ps.executeQuery())   {
                if(rs.next()) {
                    like = new Like(
                            userId,
                            typeId,
                            rs.getInt("likes")
                    );
                }
            }
        } catch (SQLException se) {
            System.out.println(se);
        }

        return like;
    }

    public int getTotalLikes(Request req) {
        int total = 0;

        String query = totalLikesQueries.get(req.params("type"));
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(query)

        ) {
            ps.setInt(1, Integer.parseInt(req.params("typeId")));
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    total = rs.getInt("total");
                }
            }
        } catch (SQLException se) {
            System.out.println(se);
        }

        return total;
    }

    public Like createLike(Request req) {
        Like like = null;
        String query = createLikeQueries.get(req.params("type"));

        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        )   {
            like = Extractor.getInstance().extractLike(req.body());
            ps.setInt(1, like.getUserId());
            ps.setInt(2, like.getTypeId());
            ps.setInt(3, like.getLike());
            ps.executeUpdate();
        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (IOException io) {
            System.out.println(io);
        }

        return like;
    }

    public Like updateLike(Request req) {
        Like like = null;
        String query = updateLikeQueries.get(req.params("type"));
        try (
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(query)
        )   {
            like = Extractor.getInstance().extractLike(req.body());
            ps.setInt(1, like.getLike());
            ps.setInt(2, like.getUserId());
            ps.setInt(3, like.getTypeId());
            ps.executeUpdate();
        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (IOException io) {
            System.out.println(io);
        }

        return like;
    }
}
