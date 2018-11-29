package com.spotter.backend.factories;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestEntryFactory {
    PostFactory factory = new PostFactory();

    @Test
    public void getEntryTest() {
        Post submission = factory.getPost("Submission","123");
        assertTrue(submission instanceof Submission);
    }

    @Test
    public void getCommentTest() {
        Post comment = factory.getPost("Comment","123");
        assertTrue(comment instanceof Comment);
    }

    @Test
    public void returnNoObject() {
        Post thisIsNull = factory.getPost("random", "");
        assertNull(thisIsNull);
    }
}
