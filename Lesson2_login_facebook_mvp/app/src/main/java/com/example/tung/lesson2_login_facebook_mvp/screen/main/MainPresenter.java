package com.example.tung.lesson2_login_facebook_mvp.screen.main;

import android.content.Intent;

import com.example.tung.lesson2_login_facebook_mvp.screen.list_friend.ListFriendsActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by tung on 5/22/17.
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View mMainView;

    public void setView(MainContract.View view) {
        mMainView = view;
    }

    @Override
    public void loginFacebook(LoginButton loginButton, CallbackManager callbackManager) {
        loginButton.setReadPermissions((Arrays.asList("user_photos", "read_custom_friendlists", "user_friends")));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mMainView.loginSuccess();
            }

            @Override
            public void onCancel() {
                mMainView.loginCancel();
            }

            @Override
            public void onError(FacebookException error) {
                mMainView.loginError();
            }
        });
    }
}
