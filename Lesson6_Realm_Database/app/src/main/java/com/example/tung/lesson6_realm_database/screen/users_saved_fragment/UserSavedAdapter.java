package com.example.tung.lesson6_realm_database.screen.users_saved_fragment;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.tung.lesson6_realm_database.R;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.databinding.ItemUserSavedBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/31/17.
 */

public class UserSavedAdapter extends RecyclerView.Adapter<UserSavedAdapter.ViewHolder> {

    private List<User> mUsers;
    private OnRecyclerViewItemClickListener mClickListener;

    public UserSavedAdapter() {
        mUsers = new ArrayList<>();
    }

    public UserSavedAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserSavedBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_user_saved, parent, false);
        return new ViewHolder(binding, mClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public void addAllItems(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public void removeItem(User user) {
        int index = mUsers.indexOf(user);
        mUsers.remove(index);
        notifyItemRemoved(index);
    }

    public void setClickListener(OnRecyclerViewItemClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemUserSavedBinding mBinding;
        private OnRecyclerViewItemClickListener mItemClickListener;

        public ViewHolder(ItemUserSavedBinding binding,
                OnRecyclerViewItemClickListener itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bindData(User user) {
            mBinding.setViewModel(new ItemUserSavedViewModel(user, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onButtonDeleteClicked(User user);
    }
}
