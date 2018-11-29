package com.spotter.backend.models;

public class Post {
    private int id;
    private int numberOfLikes;
    private int userId;
    private String text;

    public Post(int id, int numberOfLikes, int userId, String text) {
        this.id = id;
        this.numberOfLikes = numberOfLikes;
        this.userId = userId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
