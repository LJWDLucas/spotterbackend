package com.spotter.backend.models;

import java.util.Base64;

/**
 * Image submission.
 */
public class Submission extends Post {
    private int competitionId;
    private String url;
    private String imgurId;
    private String deleteHash;
    private String longitude;
    private String latitude;

    public Submission(int id, int userId, int competitionId, String imgurId, String text, int numberOfLikes, String url, String deleteHash, String longitude, String latitude) {
        super(id, userId, text, numberOfLikes);
        this.competitionId = competitionId;
        this.url = url;
        this.imgurId = imgurId;
        this.deleteHash = deleteHash;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Submission(int userId, int competitionId, String text, String longitude, String latitude) {
        super(userId, text);
        this.competitionId = competitionId;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgurId() {
        return imgurId;
    }

    public void setImgurId(String imgurId) {
        this.imgurId = imgurId;
    }

    public String getDeleteHash() {
        return deleteHash;
    }

    public void setDeleteHash(String deleteHash) {
        this.deleteHash = deleteHash;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public String getUrl() {
        return url;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
