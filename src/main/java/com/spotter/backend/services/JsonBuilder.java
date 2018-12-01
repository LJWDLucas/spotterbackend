package com.spotter.backend.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spotter.backend.utilities.MapValue;

import java.util.Map;

public class JsonBuilder {
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode commentJsonBuilder(Map<String, MapValue> map) {
        JsonNode rootNode = objectMapper.createObjectNode();
        ((ObjectNode) rootNode).put("userId", map.get("userId").getInteger());
        ((ObjectNode) rootNode).put("comment", map.get("comment").getString());
        ((ObjectNode) rootNode).put("targetId", map.get("targetId").getInteger());
        ((ObjectNode) rootNode).put("id", map.get("id").getInteger());
        ((ObjectNode) rootNode).put("numberOfLikes", map.get("numberOfLikes").getInteger());

        return rootNode;
    }
}
