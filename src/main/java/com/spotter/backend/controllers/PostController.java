package com.spotter.backend.controllers;


import spark.Request;


public interface PostController {

    String retrieveOne(Request request);

    String retrieveAll();

    String post(String body);

    String delete(Request request);

    String update(String body);
}
