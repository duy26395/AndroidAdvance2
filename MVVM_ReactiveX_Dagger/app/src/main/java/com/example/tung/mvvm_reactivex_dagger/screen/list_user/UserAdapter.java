package com.example.tung.mvvm_reactivex_dagger.screen.list_user;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.tung.mvvm_reactivex_dagger.R;
import com.example.tung.mvvm_reactivex_dagger.data.model.User;
import com.example.tung.mvvm_reactivex_dagger.databinding.ItemUserBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/30/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>();
    }

    public UserAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_user, parent, false);
        return new ViewHolder(binding);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding mBinding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bindData(User user) {
            mBinding.setViewModel(new ItemUserViewModel(user));
            mBinding.executePendingBindings();
        }
    }
}