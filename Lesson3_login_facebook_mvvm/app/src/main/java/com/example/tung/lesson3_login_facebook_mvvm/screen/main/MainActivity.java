package com.example.tung.lesson3_login_facebook_mvvm.screen.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tung.lesson3_login_facebook_mvvm.R;
import com.example.tung.lesson3_login_facebook_mvvm.databinding.ActivityMainBinding;
import com.example.tung.lesson3_login_facebook_mvvm.untils.Navigator;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    private CallbackManager mCallbackManager;
    private MainViewModel mMainViewModel;
    private LoginButton mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mCallbackManager = CallbackManager.Factory.create();
        mBtnLogin = (LoginButton) findViewById(R.id.btn_login);
        mMainViewModel = new MainViewModel(mBtnLogin, mCallbackManager, new Navigator(this));

        binding.setViewModel(mMainViewModel);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
