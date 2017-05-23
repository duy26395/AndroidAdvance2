package com.example.tung.lesson2_login_facebook_mvp.screen.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tung.lesson2_login_facebook_mvp.R;
import com.example.tung.lesson2_login_facebook_mvp.screen.list_friend.ListFriendsActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private LoginButton btnLogin;
    private CallbackManager mCallbackManager;
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (LoginButton) findViewById(R.id.btn_login);
        mMainPresenter = new MainPresenter();
        mMainPresenter.setView(this);
        mMainPresenter.loginFacebook(btnLogin, mCallbackManager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListFriendsActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginCancel() {
        Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
    }
}
