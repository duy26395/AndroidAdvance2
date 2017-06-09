package com.example.tung.mvvm_reactivex_dagger.screen.list_user;

import android.databinding.BaseObservable;
import com.example.tung.mvvm_reactivex_dagger.data.model.User;

/**
 * Created by tung on 5/30/17.
 */

public class ItemUserViewModel extends BaseObservable {

    private User mUser;

    public ItemUserViewModel(User user){
        mUser = user;
    }

    public String getId(){
        return mUser.getId().toString();
    }

    public String getName(){
        return mUser.getLogin();
    }

    public String getImageUrl(){
        return mUser.getAvatarUrl();
    }

    public String getUrl(){
        return mUser.getHtmlUrl();
    }
}
