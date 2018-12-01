package com.spotter.backend.utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Submission;

import java.io.IOException;

public class Extractor {
    private static Extractor ourInstance = new Extractor();
    private ObjectMapper objectMapper = new ObjectMapper();

    public static Extractor getInstance() {
        return ourInstance;
    }

    private Extractor() {
    }

    public String getPropertyValueAsString(String body, String property) throws IOException {
        JsonNode j = objectMapper.readTree(body);
        return j.get(property).asText();
    }

    public Competition extractCompetition(String body) throws IOException {
        String description = getPropertyValueAsString(body, "text");
        String name = getPropertyValueAsString(body, "name");
        int userId = Integer.parseInt(getPropertyValueAsString(body, "userId"));
        int numberOfLikes = Integer.parseInt(getPropertyValueAsString(body, "numberOfLikes"));
        int enabled = getPropertyValueAsString(body, "enabled") == "true" ? 1 : 0;
        return new Competition(userId, name, description, enabled == 1, numberOfLikes);
    }

    //int userId, int competitionId, String text, String longitude, String latitude
    public Submission extractSubmission(String body) throws IOException {
        int userId = Integer.parseInt(getPropertyValueAsString(body, "userId"));
        int competitionId = Integer.parseInt(getPropertyValueAsString(body, "competitionId"));
        String description = getPropertyValueAsString(body, "description");
        String longitude = getPropertyValueAsString(body, "longitude");
        String latitude = getPropertyValueAsString(body, "latitude");
        return new Submission(userId, competitionId, description, longitude, latitude);
    }
}
