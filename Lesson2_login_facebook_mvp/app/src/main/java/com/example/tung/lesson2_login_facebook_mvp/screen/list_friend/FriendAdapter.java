package com.example.tung.lesson2_login_facebook_mvp.screen.list_friend;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tung.lesson2_login_facebook_mvp.R;
import com.example.tung.lesson2_login_facebook_mvp.data.Friend;

import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private static final String TAG = "FriendAdapter";

    private List<Friend> mFriends;

    public FriendAdapter(List<Friend> friends) {
        mFriends = friends;
    }


    public void addAllItems(List<Friend> friends) {
        mFriends.clear();
        mFriends.addAll(friends);
        Log.d(TAG, "addAllItems: " + mFriends.size());
        notifyDataSetChanged();
    }

    @Override
    public FriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FriendAdapter.ViewHolder holder, int position) {
        holder.bindData(mFriends.get(position));
    }

    @Override
    public int getItemCount() {
        return mFriends == null ? 0 : mFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName;
        private ImageView mIvImage;

        public ViewHolder(View itemView) {
            super(itemView);

            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mIvImage = (ImageView) itemView.findViewById(R.id.iv_image);
        }

        public void bindData(Friend friend) {
            mTvName.setText(friend.getName());
            Glide.with(itemView.getContext())
                    .load(friend.getImage())
                    .centerCrop()
                    .into(mIvImage);
        }
    }
}
