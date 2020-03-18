package com.example.posts.ui;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.posts.R;
import com.example.posts.Repository;
import com.example.posts.model.PostsDataEntity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PostsAdapter mPostsAdapter;
    private PostsDataEntity mPostsDataEntity;
    private Repository mRepository;
    private String mTags = "Story";
    private int mPage = 1;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Posts");
        mRepository = new Repository();
        mPostsDataEntity = mRepository.getPostData(mTags, mPage);

        mRecyclerView = findViewById(R.id.rvPosts);
        mSwipeRefreshLayout = findViewById(R.id.srlPosts);

        initViews();
    }

    private void initViews() {
        mPostsAdapter = new PostsAdapter(this, mPostsDataEntity);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mPostsAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                int numberOfSelectedItems = mPostsAdapter.mNumberOfSelectedItems;
                if (numberOfSelectedItems > 0) {
                    setTitle(numberOfSelectedItems);
                } else {
                    setTitle("Posts");
                }

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPostsDataEntity = mRepository.getPostData(mTags, mPage);
                mPostsAdapter.setData(mPostsDataEntity);
            }
        });
    }
}
