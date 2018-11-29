package com.spotter.backend.controllers;


import com.spotter.backend.factories.PostFactory;
import com.spotter.backend.models.Post;
import com.spotter.backend.utilities.MapValue;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostController {
    private PostFactory f = new PostFactory();
    private ArrayList<Post> pList = new ArrayList<>();

    public ArrayList createPostList(ResultSet rs, String type, String commentOnType) {
        try {
            switch(type) {
                case "Submission":
                    return pList;
                case "Comment":
                    while(rs.next()) {
                        Map<String, MapValue> map = new HashMap<>();
                        Post comment;
                        map.put("id", new MapValue(rs.getInt("id")));
                        map.put("description", new MapValue(rs.getString("description")));
                        map.put("userId", new MapValue(rs.getInt("userId")));
                        map.put("numberOfLikes", new MapValue(rs.getInt("numberOfLikes")));
                        if (commentOnType == "Competition") {
                            map.put("competitionId", new MapValue(rs.getInt("competitionId")));
                            comment = f.getPost("Comment", map, "Competition");
                        } else {
                            map.put("submissionId", new MapValue(rs.getInt("submissionId")));
                            comment = f.getPost("Comment", map, "Submission");
                        }
                        pList.add(comment);
                    }
                    return pList;
                default:
                    return pList;
            }
        } catch(Exception e) {
            System.out.println("Couldn't create a post list.");
        }
        return pList;
    }
}
