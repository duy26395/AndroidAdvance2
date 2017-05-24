package com.example.tung.lesson3_login_facebook_mvvm.screen.listfriends;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tung.lesson3_login_facebook_mvvm.R;
import com.example.tung.lesson3_login_facebook_mvvm.data.Friend;
import com.example.tung.lesson3_login_facebook_mvvm.databinding.ItemFriendBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    private List<Friend> mFriends;

    public FriendAdapter(){
        mFriends = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemFriendBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_friend, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mFriends.get(position));
    }

    public void addAllItems(List<Friend> friends){
        mFriends.clear();
        mFriends.addAll(friends);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFriends == null ? 0 : mFriends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemFriendBinding mBinding;

        public ViewHolder(ItemFriendBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindData(Friend friend){
            mBinding.setViewModel(new ItemFriendViewModel(friend));
            mBinding.executePendingBindings();
        }
    }
}
