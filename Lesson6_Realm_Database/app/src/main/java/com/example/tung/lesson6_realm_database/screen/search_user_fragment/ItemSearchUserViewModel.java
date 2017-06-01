package com.example.tung.lesson6_realm_database.screen.search_user_fragment;

import android.util.Log;
import android.view.View;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.screen.BaseViewModel;
import io.realm.Realm;

/**
 * Created by tung on 5/31/17.
 */

public class ItemSearchUserViewModel extends BaseViewModel {

    private User mUser;
    SearchUserAdapter.OnRecyclerViewItemClickListener mItemClickListener;

    public ItemSearchUserViewModel(User user,
            SearchUserAdapter.OnRecyclerViewItemClickListener itemClickListener) {
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

    public void onButtonSaveClicked(View v) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onButtonSaveClicked(mUser);
    }
}
