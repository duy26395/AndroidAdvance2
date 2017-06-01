package com.example.tung.lesson6_realm_database.screen.users_saved_fragment;

import android.util.Log;
import android.view.View;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.screen.BaseViewModel;
import io.realm.Realm;

/**
 * Created by tung on 5/31/17.
 */

public class ItemUserSavedViewModel extends BaseViewModel {

    private User mUser;
    private UserSavedAdapter.OnRecyclerViewItemClickListener mItemClickListener;

    public ItemUserSavedViewModel(User user,
            UserSavedAdapter.OnRecyclerViewItemClickListener itemClickListener) {
        mUser = user;
        mItemClickListener = itemClickListener;
    }

    public String getId() {
        return mUser.getId().toString();
    }

    public String getName() {
        return mUser.getName();
    }

    public String getImageUrl() {
        return mUser.getAvatarUrl();
    }

    public String getUrl() {
        return mUser.getHtmlUrl();
    }

    public void onButtonDeleteClicked(View v) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onButtonDeleteClicked(mUser);
    }
}
