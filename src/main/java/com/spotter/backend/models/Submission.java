package com.spotter.backend.models;

import java.util.Base64;

/**
 * Image submission.
 */
public class Submission extends Post {
    private Base64 encodedImage;
    private String url;
    private String description;
    private long longitude;
    private long latitude;

    public Submission(int id, int numberOfLikes, int userId, String text) {
        super(id, numberOfLikes, userId, text);
    }

    public Base64 getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(Base64 encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
