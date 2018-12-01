package com.spotter.backend.models;

public class Comment extends Post {
    private int typeOfId;
    private String typeOf;

    public Comment(int id, int numberOfLikes, int userId, String text, int typeOfId, String typeOf) {
        super(id, numberOfLikes, userId, text);
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
