package com.spotter.backend.factories;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;

public class PostFactory
{
    public Post getPost(String postType, String identifier) {
        if (postType == "Submission") {
            return new Submission(identifier);
        } else if (postType == "Comment"){
            return new Comment(identifier);
        }
        return null;
    }
}
