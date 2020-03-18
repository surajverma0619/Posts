package com.example.posts.network;

import com.example.posts.model.PostsDataEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostsAPIService {

    @GET("search_by_date")
    Call<PostsDataEntity> getPostData(@Query("tags") String tags, @Query("page") int page);
}
