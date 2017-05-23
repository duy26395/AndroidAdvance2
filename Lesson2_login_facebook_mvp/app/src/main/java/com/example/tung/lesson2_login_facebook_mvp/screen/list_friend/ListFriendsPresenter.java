package com.example.tung.lesson2_login_facebook_mvp.screen.list_friend;

import android.util.Log;

import com.example.tung.lesson2_login_facebook_mvp.data.Friend;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class ListFriendsPresenter implements ListFriendsContract.Presenter {

    ListFriendsContract.View mListFriendsView;

    public ListFriendsPresenter(ListFriendsContract.View view){
        mListFriendsView = view;
    }

    @Override
    public void loadListFriends() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/taggable_friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        try {
                            JSONArray data = response.getJSONObject().getJSONArray("data");
                            Log.i("===data===", "=================================");
                            List<Friend> friends = new ArrayList<Friend>();
                            JSONObject friendJsonObj;
                            for (int i = 0; i < data.length(); i++) {
                                friendJsonObj = data.getJSONObject(i);
                                String name = friendJsonObj.getString("name");
                                String image = friendJsonObj.getJSONObject("picture").getJSONObject("data").getString("url");
                                System.out.println("name: " + name + " - image: " + image);
                                friends.add(new Friend(name, image));
                            }
                            mListFriendsView.loadListFriendSuccess(friends);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.i("===data===", "---------------error-----------");
                        }
                    }
                }
        ).executeAsync();
    }
}
