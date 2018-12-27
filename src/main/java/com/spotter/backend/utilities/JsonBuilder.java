package com.spotter.backend.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spotter.backend.models.Like;
import com.spotter.backend.models.Post;

import java.util.ArrayList;

public class JsonBuilder {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String valueToJson(boolean bool, String nodeName) {
        JsonNode rootNode = objectMapper.createObjectNode();
        ((ObjectNode) rootNode).put(nodeName, bool);
        return toJson(rootNode);
    }

    public String valueToJson(int value, String nodeName) {
        JsonNode rootNode = objectMapper.createObjectNode();
        ((ObjectNode) rootNode).put(nodeName, value);
        return toJson(rootNode);
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

    public String mapToJson(Like like) {
        String result = "";
        try {
            result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(like);
        } catch (JsonProcessingException jpe) {
            // handle
        }
        return result;
    }

    private String toJson(JsonNode rootNode) {
        String result = "";
        try {
            result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe);
        }
        return result;
    }
}
