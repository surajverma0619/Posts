package com.example.posts.model;

public class PostsDataEntity {

    private Hits[] hits;
    private String hitsPerPage;
    private String query;
    private int page;
    private String params;
    private int processingTimeMS;


    public void setHitsPerPage(String hitsPerPage) {
        this.hitsPerPage = hitsPerPage;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setProcessingTimeMS(int processingTimeMS) {
        this.processingTimeMS = processingTimeMS;
    }

    public void setHits(Hits[] hits) {

        this.hits = hits;
    }

    public Hits[] getHits() {
        return hits;
    }

    public PostsDataEntity(Hits[] hits, String hitsPerPage, String query, int page, String params, int processingTimeMS) {
        this.hits = hits;
        this.hitsPerPage = hitsPerPage;
        this.query = query;
        this.page = page;
        this.params = params;
        this.processingTimeMS = processingTimeMS;
    }

    public String getHitsPerPage() {
        return hitsPerPage;
    }

    public String getQuery() {
        return query;
    }

    public int getPage() {
        return page;
    }

    public String getParams() {
        return params;
    }

    public int getProcessingTimeMS() {
        return processingTimeMS;
    }


}
