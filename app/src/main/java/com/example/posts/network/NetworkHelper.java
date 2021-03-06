package com.example.posts.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    private  String baseUrl = "https://hn.algolia.com/api/v1/";
     Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public PostsAPIService service = retrofit.create(PostsAPIService.class);
}
