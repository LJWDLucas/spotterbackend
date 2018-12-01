package com.spotter.backend.models;

public class Comment extends Post {
    private int typeOfId;
    private String typeOf;

    public Comment(int commentId, int userId, String text, int numberOfLikes, int typeOfId, String typeOf) {
        super(commentId, userId, text, numberOfLikes);
        this.typeOfId = typeOfId;
        this.typeOf = typeOf;
    }

    public int gettypeOfId() {
        return typeOfId;
    }

    public String getTypeOf() {
        return typeOf;
    }
}
