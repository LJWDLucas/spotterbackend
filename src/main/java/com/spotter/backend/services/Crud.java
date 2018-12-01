package com.spotter.backend.services;

import com.spotter.backend.models.Post;

import java.util.ArrayList;

public interface Crud {
    Post get(int id);
    ArrayList<?> getAll();
    ArrayList<?> getAllById(int id);
    Post post(String body);
    Post post(Post post);
    boolean delete(int id);
    Post update(String body);
}
