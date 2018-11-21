package com.spotter.backend.factories;

import com.spotter.backend.models.Comment;
import com.spotter.backend.models.Post;
import com.spotter.backend.models.Submission;

public class EntryFactory {
    public Post getEntry(String entryType, String identifier) {
        if (entryType == "Submission") {
            return new Submission(identifier);
        } else if (entryType == "Comment"){
            return new Comment(identifier);
        }
        return null;
    }
}
