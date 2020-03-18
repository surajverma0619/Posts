package com.example.posts.networkCalls;

import com.example.posts.model.PostsDataEntity;
import com.example.posts.network.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRequest {
    private NetworkHelper networkHelper;
    private PostsDataEntity postsDataEntity;

    public PostsDataEntity getPostData(String tags, int page) {
        networkHelper = new NetworkHelper();
        Call<PostsDataEntity> call = networkHelper.service.getPostData(tags, page);
        call.enqueue(new Callback<PostsDataEntity>() {
            @Override
            public void onResponse(Call<PostsDataEntity> call, Response<PostsDataEntity> response) {
                if (response.isSuccessful()) {
                    postsDataEntity = response.body();
                } else {
                    postsDataEntity = null;
                }
            }

            @Override
            public void onFailure(Call<PostsDataEntity> call, Throwable t) {
                postsDataEntity = null;
            }
        });
        return postsDataEntity;
    }
}
