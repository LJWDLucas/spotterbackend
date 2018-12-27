package com.spotter.backend.models;

public class Like {
    private int userId;
    private int typeId;
    private int like;

    public Like(int userId, int typeId, int like) {
        this.userId = userId;
        this.typeId = typeId;
        this.like = like;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * -1 = dislike
     * 0 = no opinion
     * 1 = like
     * @return
     */
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
