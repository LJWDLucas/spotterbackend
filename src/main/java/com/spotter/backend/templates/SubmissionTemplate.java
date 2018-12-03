package com.spotter.backend.templates;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotter.backend.models.Competition;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;
import com.spotter.backend.services.CrudSubmission;
import com.spotter.backend.services.ExternalCalls;
import com.spotter.backend.utilities.Extractor;
import spark.Request;

import java.util.ArrayList;

public class SubmissionTemplate extends GenericTemplate {
    private CrudSubmission crud = new CrudSubmission();
    private ExternalCalls ec = new ExternalCalls();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected ArrayList<Post> getAllDataById(Request req) {
        return crud.getAllById(Integer.parseInt(req.params("id")));
    }

    @Override
    public Submission postData(String body) {
        Submission submission = null;
        try {
            String imgurResponse = ec.postToImgUr(body);
            JsonNode jsonNode = objectMapper.readTree(imgurResponse);
            JsonNode dataNode = jsonNode.get("data");
            String deleteHash = dataNode.get("deletehash").asText();
            String imgurId = dataNode.get("id").asText();
            String url = dataNode.get("link").asText();
            submission = Extractor.getInstance().extractSubmission(body);
            submission.setDeleteHash(deleteHash);
            submission.setUrl(url);
            submission.setImgurId(imgurId);
            submission.setNumberOfLikes(0);
        } catch (Exception e) {
            // handle
            System.out.println(

            );
        }
        return crud.post(submission);
    }

    @Override
    protected boolean deleteData(Request req) {
        return crud.delete(Integer.parseInt(req.params("id")));
    }

    /**
     * No implementation required.
     * @return null;
     */
    @Override
    public Submission getData(Request req) {
        return null;
    }

    /**
     * No implementation required.
     * @return null;
     */
    @Override
    public Competition updateData(String body) {
        return null;
    }

    /**
     * No implementation required.
     * @return null;
     */
    @Override
    public ArrayList<Post> getAllData() {
        return null;
    }
}
