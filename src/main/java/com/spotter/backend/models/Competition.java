package com.spotter.backend.models;

import java.util.ArrayList;


/**
 * Mind that the database stores a boolean as an integer. Don't forget to map bool to int before inserting!
 */
public class Competition extends Post {
    private String name;
    private boolean enabled;
    private ArrayList<Reward> rewards = new ArrayList<>();

    public Competition(int id, int userId, String name, String description, boolean enabled, int numberOfLikes) {
        super(id, userId, description, numberOfLikes);
        this.enabled = enabled;
        this.name = name;
    }

    public Competition(int userId, String name, String description, boolean enabled,  int numberOfLikes) {
        super(userId, description, numberOfLikes);
        this.enabled = enabled;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Competition) {
            Post c = (Competition) o;
            return (c.getId() == getId()) &&
                    (c.getText() == getText()) &&
                    (((Competition) c).isEnabled() == isEnabled()) &&
                    (c.getUserId() == getUserId()) &&
                    (c.getNumberOfLikes() == getNumberOfLikes());
        }
        return false;
    }
}
