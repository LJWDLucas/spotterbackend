package com.spotter.backend.models;

public class Post {
    private int id;
    private int numberOfLikes;
    private int userId;
    private String text;

    protected Post(int id,int userId, String text,  int numberOfLikes) {
        this.id = id;
        this.numberOfLikes = numberOfLikes;
        this.userId = userId;
        this.text = text;
    }

    protected Post(int userId, String text, int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
        this.userId = userId;
        this.text = text;
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected int getNumberOfLikes() {
        return numberOfLikes;
    }

    protected void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    protected int getUserId() {
        return userId;
    }

    protected void setUserId(int userId) {
        this.userId = userId;
    }

    protected String getText() {
        return text;
    }

}
