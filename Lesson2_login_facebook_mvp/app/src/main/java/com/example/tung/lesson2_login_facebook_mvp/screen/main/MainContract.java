package com.example.tung.lesson2_login_facebook_mvp.screen.main;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

/**
 * Created by tung on 5/22/17.
 */

public class MainContract {
    public interface View{
        void loginSuccess();
        void loginError();
        void loginCancel();

    }
    public interface Presenter{
        void loginFacebook(LoginButton loginButton, CallbackManager callbackManager);
    }
}
