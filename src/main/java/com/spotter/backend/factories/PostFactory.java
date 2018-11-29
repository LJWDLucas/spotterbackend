package com.spotter.backend.factories;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;
import com.spotter.backend.utilities.MapValue;

import java.util.Map;

public class PostFactory
{
    public Post getPost(String postType, Map<String, MapValue> map, String commentOnType) {
        if (postType == "Submission") {
            return new Submission(
                    map.get("id").getInteger(),
                    map.get("numberOfLikes").getInteger(),
                    map.get("userId").getInteger(),
                    map.get("description").getString()
            );
        } else if (postType == "Comment"){
            if (commentOnType == "Submission") {
                return new Comment(
                        map.get("id").getInteger(),
                        map.get("numberOfLikes").getInteger(),
                        map.get("userId").getInteger(),
                        map.get("text").getString(),
                        map.get("submissionId").getInteger()
                );
            } else {
                return new Comment(
                        map.get("id").getInteger(),
                        map.get("numberOfLikes").getInteger(),
                        map.get("userId").getInteger(),
                        map.get("text").getString(),
                        map.get("competitionId").getInteger()
                );
            }
        }
        return null;
    }
}
