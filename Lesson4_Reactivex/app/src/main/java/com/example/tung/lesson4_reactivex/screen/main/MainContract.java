package com.example.tung.lesson4_reactivex.screen.main;

import com.example.tung.lesson4_reactivex.data.model.User;

import java.util.List;

/**
 * Created by tung on 5/26/17.
 */

public class MainContract {

    public interface View {
        void searchSuccess(List<User> users);
    }

    public interface Presenter {
        void searchUsers(String keyWord, int pageSize, int page);
        void onStop();
    }
}
