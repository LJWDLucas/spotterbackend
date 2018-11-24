package com.spotter.backend.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Mapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public Mapper() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String getPropertyValueAsString(String body, String property) throws IOException {
        JsonNode j = objectMapper.readTree(body);
        return j.get(property).asText();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
