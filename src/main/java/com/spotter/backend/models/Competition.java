package com.spotter.backend.models;

import java.util.ArrayList;


/**
 * Mind that the database stores a boolean as an integer. Don't forget to map bool to int before inserting!
 */
public class Competition {
    private int id;
    private String description;
    private boolean enabled;
    private Reward rewards = new Reward();
    private ArrayList<Post> posts = new ArrayList<>();

    public Competition(int id) {
        this.id = id;
    }

    public Competition(int id, String description, int enabled) {
        this.id = id;
        this.description = description;
        // Database stores true as 1 and false as 0.
        if (enabled == 1) {
            this.enabled = true;
        } else {
            this.enabled = false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Reward getRewards() {
        return rewards;
    }

    public void setRewards(Reward rewards) {
        this.rewards = rewards;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
