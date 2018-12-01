package com.spotter.backend.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Crud {
    private final String getCompetitionQuery = "SELECT * FROM competitions WHERE id = ";
    private final String getAllCompetitionsQuery = "SELECT * FROM competitions";
    private final String getCompetitonCommentsQuery = "SELECT * FROM competitionComments WHERE competitionId = ";
    private final String updateCompetitionCommentQuery = "UPDATE competitionComments SET comment = ? WHERE id = ?";
    private final String updateSubmissionCommentQuery = "UPDATE submissionComments SET comment = ? WHERE id = ?";

    public ResultSet getCompetition(String id) {
        return DatabaseService.get(getCompetitionQuery + id);
    }

    public ResultSet getAllCompetitions() {
        return DatabaseService.get(getAllCompetitionsQuery);
    }

    public ResultSet getCompetitionComments(String competitionId) {
        return DatabaseService.get(getCompetitonCommentsQuery + competitionId);
    }

    /**
     *
     * @param targetId Who knows.
     * @param userId  Whatever
     * @param comment Whatever
     * @param tableName  competitionComments / submissionComments
     * @param targetIdColumnName competitionId / submissionId
     * @return
     * @throws Exception
     */
    public int postComment(String userId, String comment, String tableName, String targetIdColumnName, String targetId) {

        try {
            PreparedStatement st = DatabaseService.getConnection().prepareStatement(
                    "INSERT INTO " + tableName +
                            "(userId, " + targetIdColumnName + ", comment) " +
                            "VALUES(" + userId + "," + targetId + ",\"" + comment + "\")",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.execute();
            ResultSet result = st.getGeneratedKeys();
            int id = -1;
            while (result.next()) {
                id = result.getInt(1);
            }
            return id;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    /**
     * To do: Check if user making the put request is the one who posted the request.
     * @param commentId
     * @param newComment
     * @return
     */
    public int updateCompetitionComment(String commentId, String newComment) {
        return DatabaseService.update(updateCompetitionCommentQuery, commentId, newComment);
    }

    public int updateSubmissionComment(String commentId, String newComment) {
        return DatabaseService.update(updateSubmissionCommentQuery, commentId, newComment);
    }
}
