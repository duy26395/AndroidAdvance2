package com.example.tung.lesson5_dagger2.screen.main;

import com.example.tung.lesson5_dagger2.data.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tung on 5/29/17.
 */

public class MainContract {
    interface View {
        void onGetUsersSuccess(List<User> users);
    }

    interface Presenter {
        void searchUsers(String keyWord, int pageSize, int page);

        public void onStop();
    }
}
