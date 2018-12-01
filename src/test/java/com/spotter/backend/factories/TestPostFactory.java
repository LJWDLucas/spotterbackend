package com.spotter.backend.factories;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;
import com.spotter.backend.utilities.MapValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestPostFactory {
    PostFactory factory = new PostFactory();
    Map<String, MapValue> testmap = new HashMap<>();

    @BeforeEach
    public void initialize() {
        testmap.put("id", new MapValue(1));
        testmap.put("userId", new MapValue(1));
        testmap.put("submissionId", new MapValue(1));
        testmap.put("competitionId", new MapValue(1));
        testmap.put("description", new MapValue("Test"));
        testmap.put("text", new MapValue("Test"));
        testmap.put("numberOfLikes", new MapValue(0));
    }
//
//    @Test
//    public void getSubmissionTest() {
//        Post submission = factory.getPost("Submission", testmap, null);
//        assertTrue(submission instanceof Submission);
//    }
//
//    @Test
//    public void getCommentTest() {
//        Post comment = factory.getPost("Comment", testmap, "Submission");
//        assertTrue(comment instanceof Comment);
//    }
//
//    @Test
//    public void returnNoObject() {
//        Post thisIsNull = factory.getPost("random", testmap, null);
//        assertNull(thisIsNull);
//    }
}
