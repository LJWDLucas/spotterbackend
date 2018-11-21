package com.spotter.backend.models;

import java.util.Base64;

/**
 * Image submission.
 */
public class Submission extends Post {
    private Base64 encodedImage;
    private String url;
    private String descrption;
    private String submitter;
    private long longitude;
    private long latitude;

    public Submission(String identifier) {
        super(identifier);
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

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }
}
