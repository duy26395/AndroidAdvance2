package com.example.tung.lesson6_realm_database.screen.search_user_fragment;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.tung.lesson6_realm_database.R;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.databinding.ItemSearchUserBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/31/17.
 */

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.ViewHolder> {

    private List<User> mUsers;

    private SearchUserAdapter.OnRecyclerViewItemClickListener mClickListener;

    public SearchUserAdapter() {
        mUsers = new ArrayList<>();
    }

    public SearchUserAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSearchUserBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_search_user, parent, false);
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

    public void setClickListener(OnRecyclerViewItemClickListener clickListener){
        mClickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemSearchUserBinding mBinding;
        private OnRecyclerViewItemClickListener mItemClickListener;

        public ViewHolder(ItemSearchUserBinding binding, OnRecyclerViewItemClickListener itemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bindData(User user) {
            mBinding.setViewModel(new ItemSearchUserViewModel(user, mItemClickListener));
            mBinding.executePendingBindings();
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onButtonSaveClicked(User user);
    }
}
