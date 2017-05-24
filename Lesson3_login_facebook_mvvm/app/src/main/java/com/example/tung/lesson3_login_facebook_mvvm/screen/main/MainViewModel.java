package com.example.tung.lesson3_login_facebook_mvvm.screen.main;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.example.tung.lesson3_login_facebook_mvvm.screen.listfriends.ListFriendsActivity;
import com.example.tung.lesson3_login_facebook_mvvm.untils.Navigator;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by tung on 5/23/17.
 */

public class MainViewModel extends BaseObservable{

    LoginButton mLoginButton;
    CallbackManager mCallbackManager;
    Navigator mNavigator;

    public MainViewModel(LoginButton loginButton, CallbackManager callbackManager, Navigator navigator){
        mLoginButton = loginButton;
        mCallbackManager = callbackManager;
        mNavigator = navigator;
    }

    public void LoginButtonClicked(View v){
        loginFacebook();
    }
    public void loginFacebook(){
        mLoginButton.setReadPermissions(
                (Arrays.asList("user_photos", "read_custom_friendlists", "user_friends")));
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mNavigator.startActivity(new Intent(mNavigator.getActivity(), ListFriendsActivity.class));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

}
