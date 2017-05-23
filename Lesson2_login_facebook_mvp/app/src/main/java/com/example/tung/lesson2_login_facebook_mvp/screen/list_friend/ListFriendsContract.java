package com.example.tung.lesson2_login_facebook_mvp.screen.list_friend;

import com.example.tung.lesson2_login_facebook_mvp.data.Friend;

import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class ListFriendsContract {
    public interface View{
        void loadListFriendSuccess(List<Friend> friends);
    }
    public interface Presenter{
        void loadListFriends();
    }
}
