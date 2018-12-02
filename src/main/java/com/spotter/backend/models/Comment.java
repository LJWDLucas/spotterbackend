package com.spotter.backend.models;

public class Comment extends Post {
    private int flexId;

    public Comment(int commentId, int userId, String comment, int flexId) {
        super(commentId, userId, comment);
        this.flexId = flexId;
    }

    public Comment(int userId, String comment, int flexId) {
        super(userId, comment);
        this.flexId = flexId;
    }

    public int getFlexId() {
        return flexId;
    }

    public void setFlexId(int flexId) {
        this.flexId = flexId;
    }

    @Override
    public void setNumberOfLikes(int numberOfLikes) {
        super.setNumberOfLikes(numberOfLikes);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }
}
