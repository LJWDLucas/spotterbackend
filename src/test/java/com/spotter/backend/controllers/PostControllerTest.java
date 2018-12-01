package com.spotter.backend.controllers;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PostControllerTest {
//    private PostController pc = new PostController();
//    private ResultSet rs = Mockito.mock(ResultSet.class);
//    private ArrayList<Post> postList;
//
//    @BeforeEach
//    public void initialize() throws SQLException {
//        Mockito.when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
//        Mockito.when(rs.getInt("id")).thenReturn(1).thenReturn(1);
//        Mockito.when(rs.getString("comment")).thenReturn("This is a test.").thenReturn("This is a test.");
//        Mockito.when(rs.getInt("userId")).thenReturn(1).thenReturn(1);
//        Mockito.when(rs.getInt("competitionId")).thenReturn(1).thenReturn(1);
//        Mockito.when(rs.getInt("numberOfLikes")).thenReturn(0).thenReturn(1);
//        postList = pc.createPostList(rs, "Comment", "Competition");
//    }
//
//    @Test
//    public void testCreatePostList() {
//        assertEquals( 2, postList.size());
//    }
//
//    @Test
//    public void testPostListContents() {
//        Post c = postList.get(0);
//        assertTrue(c instanceof Comment);
//    }
}
