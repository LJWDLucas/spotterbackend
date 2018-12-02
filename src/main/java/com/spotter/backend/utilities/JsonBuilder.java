package com.spotter.backend.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spotter.backend.models.Post;

import java.util.ArrayList;

public class JsonBuilder {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String wasSuccessful(boolean bool) {
        JsonNode rootNode = objectMapper.createObjectNode();
        ((ObjectNode) rootNode).put("successful", bool);
        String result = "";
        try {
            result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (JsonProcessingException jpe) {
            // handle
        }
        return result;
    }

    public String mapToJson(ArrayList<Post> pList) {
        String result = "";
        try {
            result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pList);
        } catch (JsonProcessingException jpe) {
            // handle
        }
        return result;
    }
}
