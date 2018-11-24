package com.spotter.backend.models;

import java.util.ArrayList;


/**
 * Mind that the database stores a boolean as an integer. Don't forget to map bool to int before inserting!
 */
public class Competition {
    private int id;
    private int userId;
    private String description;
    private boolean enabled;
    private ArrayList<Reward> rewards = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();

    public Competition(int id) {
        this.id = id;
    }

    public Competition(int id, String description, int enabled, int userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        // Database stores true as 1 and false as 0.
        if (enabled == 1) {
            this.enabled = true;
        } else {
            this.enabled = false;
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isEnabled() {
        return enabled;
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

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void setRewards( ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Competition) {
            Competition c = (Competition) o;
            return (c.getId() == getId()) &&
                    (c.getDescription() == getDescription()) &&
                    (c.getEnabled() == getEnabled()) &&
                    (c.getUserId() == getUserId());
        }
        return false;
    }
}
