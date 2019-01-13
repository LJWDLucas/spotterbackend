package com.spotter.backend.models;

public class User {

    private String email;
    private int id;
    private String password;

    public User(String email, int id, String password) {
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


}
