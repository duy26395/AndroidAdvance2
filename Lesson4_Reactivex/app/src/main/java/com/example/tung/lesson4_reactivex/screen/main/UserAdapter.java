package com.example.tung.lesson4_reactivex.screen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tung.lesson4_reactivex.R;
import com.example.tung.lesson4_reactivex.data.model.User;

import java.util.List;

/**
 * Created by tung on 5/26/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mUsers;

    public UserAdapter(List<User> users){
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public void addAllItems(List<User> users){
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextId, mTextName, mTextUrl;
        private ImageView mImageAvatar;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextId = (TextView) itemView.findViewById(R.id.text_id);
            mTextName = (TextView) itemView.findViewById(R.id.text_name);
            mTextUrl = (TextView) itemView.findViewById(R.id.text_url);
            mImageAvatar = (ImageView) itemView.findViewById(R.id.image_avatar);
        }

        public void bindData(User user){
            mTextId.setText("Id: " + user.getId());
            mTextName.setText("Name: " + user.getName());
            mTextUrl.setText("Url: " + user.getHtmlUrl());
            Glide.with(itemView.getContext())
                    .load(user.getAvatarUrl())
                    .centerCrop()
                    .into(mImageAvatar);
        }
    }
}
