package com.spotter.backend.services;

import com.spotter.backend.models.Post;

import java.util.ArrayList;

public interface Crud {
    Post get(int id);
    ArrayList<?> getAll();
    Post post(String body);
    boolean delete(int id);
    Post update(String body);
}
