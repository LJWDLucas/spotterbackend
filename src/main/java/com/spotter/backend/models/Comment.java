package com.spotter.backend.models;

public class Comment extends Post {
    private int wildcardId;

    public Comment(int id, int numberOfLikes, int userId, String text, int wildcardId) {
        super(id, numberOfLikes, userId, text);
        this.wildcardId = wildcardId;
    }
}
