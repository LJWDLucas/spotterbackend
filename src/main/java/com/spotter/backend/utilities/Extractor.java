package com.spotter.backend.utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotter.backend.models.Competition;

import java.io.IOException;

public class Extractor {
    private ObjectMapper objectMapper = new ObjectMapper();

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
}
