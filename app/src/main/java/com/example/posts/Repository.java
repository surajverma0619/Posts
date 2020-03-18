package com.example.posts;

import com.example.posts.model.PostsDataEntity;
import com.example.posts.networkCalls.NetworkRequest;

public class Repository {

    private NetworkRequest networkRequest = new NetworkRequest();

    public PostsDataEntity getPostData(String tags, int page){
        return networkRequest.getPostData(tags,page);
    }

}
