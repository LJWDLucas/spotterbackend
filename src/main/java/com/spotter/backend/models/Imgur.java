package com.spotter.backend.models;

public class Imgur {
    private String link;
    private String deleteHash;
    private String imgurId;
    private int dbId;

    public static class Builder {
        private String link;
        private String deleteHash;
        private String imgurId;
        private int dbId;

        public Builder() {}

        public Builder withImgUrLink(String link) {
            this.link = link;
            return this;
        }

        public Builder withDeleteHash(String dHash) {
            deleteHash = dHash;
            return this;
        }

        public Builder withImgUrId(String id) {
            imgurId = id;
            return this;
        }

        public Builder withDbId(int id){
            dbId = id;
            return this;
        }

        public Imgur build() {
            return new Imgur(this);
        }
    }


    private Imgur(Builder builder) {
        this.link = builder.link;
        this.deleteHash = builder.deleteHash;
        this.imgurId = builder.imgurId;
        this.dbId = builder.dbId;
    }

    public String getLink() {
        return link;
    }

    public String getDeleteHash() {
        return deleteHash;
    }

    public String getImgurId() {
        return imgurId;
    }

    public int getDbId() {
        return dbId;
    }
}
