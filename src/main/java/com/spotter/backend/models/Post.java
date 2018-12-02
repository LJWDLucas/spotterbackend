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

    public Post(int id, int userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
    }

    protected Post(int userId, String text) {
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


}
