package com.spotter.backend.controllers;

import com.spotter.backend.services.CrudLogin;
import com.spotter.backend.models.User;
import com.spotter.backend.utilities.Extractor;
import com.spotter.backend.utilities.JsonBuilder;
import spark.Request;

import java.io.IOException;

public class LoginController {
    private JsonBuilder builder = new JsonBuilder();
    private CrudLogin crud = new CrudLogin();

    public String login(Request req) {
        boolean isValid = crud.loginUser(req);
        return builder.valueToJson(isValid, "isValid");
    }

    public String createUser(Request req) {
        String email = "";
        String password = "";
        int userId = -1;

        try {
            email = Extractor.getInstance().getPropertyValueAsString(req.body(), "email");
            password = Extractor.getInstance().getPropertyValueAsString(req.body(), "password");
            userId = crud.createUser(email, password);
        } catch (IOException e) {
            System.out.println(e);
        }

        if(userId == -1) {
            return builder.valueToJson(false, "createdUser");
        }

        User user = new User(email, userId, password);

        return builder.mapToJson(user);
    }
}
