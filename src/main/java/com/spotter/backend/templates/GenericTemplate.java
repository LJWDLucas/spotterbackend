package com.spotter.backend.templates;

import com.spotter.backend.models.Post;
import com.spotter.backend.utilities.JsonBuilder;
import spark.Request;

import java.util.ArrayList;

public abstract class GenericTemplate {
    private JsonBuilder builder = new JsonBuilder();

    /**
     * Single retrieval of a Post. Requires at least the "id" parameter. May require more depending on implementation.
     * @param req
     * @return
     */
    public final String retrieveFromDatabase(Request req) {
        ArrayList<Post> pList = new ArrayList<>();
        pList.add(getData(req));
        return constructJson(pList);
    }

    /**
     * Retrieves all of a specific Post subclass.
     * @return
     */
    public final String retrieveAllFromDatabase() {
        ArrayList<Post> pList = getAllData();
        return constructJson(pList);
    }

    public final String retrieveAllFromDataBaseById(Request req) {
        ArrayList<Post> pList = getAllDataById(req);
        return constructJson(pList);
    }
    /**
     * Add subclass to database and return the Json string.
     * @param body
     * @return
     */
    public final String addToDatabase(String body) {
        ArrayList<Post> pList = new ArrayList<>();
        pList.add(postData(body));
        return constructJson(pList);
    }

    /**
     * Update record in database and return the Json string;
     * @param body
     * @return
     */
    public final String updateInDatabase(String body) {
        ArrayList<Post> pList = new ArrayList<>();
        pList.add(updateData(body));
        return constructJson(pList);
    }

    /**
     * Delete a record. Returns either successful = true or false.
     * @param req
     * @return
     */
    public final String deleteFromDatabase(Request req) {
        boolean wasSuccessful = deleteData(req);
        return builder.wasSuccessful(wasSuccessful);
    }

    /**
     * Generic implementation of mapping any Post subclass to a Json.
     * @param pList
     * @return
     */
    protected String constructJson(ArrayList<Post> pList) {
        return builder.mapToJson(pList);
    }

    protected abstract ArrayList<Post> getAllData();
    protected abstract ArrayList<Post> getAllDataById(Request req);
    protected abstract Post getData(Request req);
    protected abstract Post postData(String body);
    protected abstract Post updateData(String body);
    protected abstract boolean deleteData(Request req);
}
