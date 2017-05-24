package com.example.tung.lesson3_login_facebook_mvvm.screen.listfriends;

import android.databinding.BaseObservable;

import com.example.tung.lesson3_login_facebook_mvvm.data.Friend;
import com.example.tung.lesson3_login_facebook_mvvm.untils.Navigator;

/**
 * Created by tung on 5/23/17.
 */

public class ItemFriendViewModel extends BaseObservable {

    Friend mFriend;

    public ItemFriendViewModel(Friend friend){
        mFriend = friend;
    }

    public String getName(){
        return mFriend.getName();
    }

    public String getImage(){
        return mFriend.getImage();
    }
}
