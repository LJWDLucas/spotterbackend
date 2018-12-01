package com.spotter.backend.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.util.stream.Collectors.joining;

public class Mapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Mapper() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


//    public String getAllCompetitionComments(String id) throws JsonProcessingException {
//        ResultSet rs = crud.getCompetitionComments(id);
//        ArrayList<Post> cList = postController.createPostList(rs, "Comment", "Competition");
//        return objectMapper.writeValueAsString(cList);
//    }

//    public String getAllCompetitionSubmissions(String id) {
//        return "to do";
//    }
//
//    public String getAllCompetitionSubmissionComments(String competitionId, String submissionId) {
//        return "to do";
//    }
//
//
//    public String postComment(String body, String tableName, String targetIdColumnName) throws Exception {
//        String targetId = extractor.getPropertyValueAsString(body, "targetId");
//        String userId = extractor.getPropertyValueAsString(body, "userId");
//        String comment = extractor.getPropertyValueAsString(body, "comment");
//        int id = crud.postComment(userId, comment, tableName, targetIdColumnName, targetId);
//        Map<String, MapValue> map = new HashMap<>();
//        map.put("userId", new MapValue(Integer.parseInt(userId)));
//        map.put("comment", new MapValue(comment));
//        // Target id is either the submissionId or the competitionId, depending on which route let to this function.
//        map.put("targetId", new MapValue(Integer.parseInt(targetId)));
//        map.put("id", new MapValue(id));
//        map.put("numberOfLikes", new MapValue(0));
//        return objectMapper.writeValueAsString(jsonBuilder.commentJsonBuilder(map));
//    };
//
//
//    /**
//     * Returns -1, 0 or 1. -1 = failure. 0 = nothing updated, 1 = row updated.
//     * @param body
//     * @param type
//     * @return
//     * @throws Exception
//     */
//
//    public String updateComment(String body, String type) throws Exception {
//        int result;
//        String comment = extractor.getPropertyValueAsString(body,"comment");
//        String commentId = extractor.getPropertyValueAsString(body, "commentId");
//        String userId = extractor.getPropertyValueAsString(body, "userId");
//        if (type == "Submission") {
//            result = crud.updateSubmissionComment(commentId, comment);
//        } else {
//            result = crud.updateCompetitionComment(commentId, comment);
//        }
//        Map<String, MapValue> map = new HashMap<>();
//        map.put("result", new MapValue(result));
//        map.put("comment", new MapValue(comment));
//        map.put("commentId", new MapValue(commentId));
//        map.put("userId", new MapValue(userId));
//        return objectMapper.writeValueAsString(map);
//    }
}
