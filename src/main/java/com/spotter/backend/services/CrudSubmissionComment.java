package com.spotter.backend.services;

import com.spotter.backend.models.Post;

import java.util.ArrayList;

public class CrudSubmissionComment implements Crud {
    @Override
    public Post get(int id) {
        return null;
    }

    @Override
    public Post post(String body, Post post) {
        return null;
    }

    @Override
    public ArrayList<?> getAll() {
        return null;
    }

    @Override
    public ArrayList<?> getAllById(int id) {
        return null;
    }

    @Override
    public Post post(String body) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Post update(String body) {
        return null;
    }
}
