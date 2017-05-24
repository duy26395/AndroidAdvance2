package com.example.tung.lesson3_login_facebook_mvvm.screen.listfriends;

import android.databinding.BaseObservable;
import android.util.Log;
import android.view.View;

import com.example.tung.lesson3_login_facebook_mvvm.data.Friend;
import com.example.tung.lesson3_login_facebook_mvvm.data.FriendsJsonObj;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class ListFriendViewModel extends BaseObservable {

    private FriendAdapter mAdapter;
    private List<Friend> mFriends;

    public ListFriendViewModel(FriendAdapter adapter) {
        mAdapter = adapter;
        mFriends = new ArrayList<>();
        loadFriends();
    }

    public FriendAdapter getAdapter() {
        return mAdapter;
    }

    public void onBtnReloadClick(View v) {
        loadFriends();
    }

    public void loadFriends() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/taggable_friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        FriendsJsonObj friendsJsonObj = new Gson().fromJson(response.getRawResponse(), FriendsJsonObj.class);
                        mFriends = friendsJsonObj.getFriends();
                        mAdapter.addAllItems(mFriends);
                    }
                }
        ).executeAsync();
    }
}
