package com.example.posts.model;

public class Hits {
    private String created_at;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreated_at() {
        return created_at;
    }
    public String getTitle(){
        return title;
    }

    public Hits(String created_at, String title) {
        this.created_at = created_at;
        this.title = title;
    }


}
