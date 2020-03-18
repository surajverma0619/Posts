package com.example.posts.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posts.R;
import com.example.posts.model.Hits;
import com.example.posts.model.PostsDataEntity;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private Context context;
    private PostsDataEntity postsDataEntity;
    private Boolean isChecked;
    public int mNumberOfSelectedItems = 0;


    public PostsAdapter(Context context, PostsDataEntity postsDataEntity) {
        this.postsDataEntity = postsDataEntity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Hits[] hits = postsDataEntity.getHits();
        String createdAtDate = hits[position].getCreated_at();
        String title = hits[position].getTitle();

        holder.tvDate.setText(createdAtDate);
        holder.tvTitle.setText(title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.selectionSwitch.isChecked()){
                    holder.selectionSwitch.setChecked(false);
                    mNumberOfSelectedItems = mNumberOfSelectedItems-1;
                }else{
                    holder.selectionSwitch.setChecked(true);
                    mNumberOfSelectedItems = mNumberOfSelectedItems+1;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsDataEntity.getHits().length;
    }

    public void setData(PostsDataEntity postsDataEntity) {
        this.postsDataEntity = postsDataEntity;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle = itemView.findViewById(R.id.tvTitleText);
        TextView tvDate = itemView.findViewById(R.id.tvPostDate);
        Switch selectionSwitch = itemView.findViewById(R.id.switchPost);

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

