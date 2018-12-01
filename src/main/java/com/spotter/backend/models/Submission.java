package com.spotter.backend.models;

import java.util.Base64;

/**
 * Image submission.
 */
public class Submission extends Post {
    private String url;
    private long longitude;
    private long latitude;

    public Submission(int id, int userId, String text, int numberOfLikes) {
        super(id, userId, text, numberOfLikes);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
