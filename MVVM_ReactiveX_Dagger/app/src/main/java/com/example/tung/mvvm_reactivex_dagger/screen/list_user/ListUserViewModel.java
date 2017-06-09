package com.example.tung.mvvm_reactivex_dagger.screen.list_user;

import android.databinding.BaseObservable;
import com.example.tung.mvvm_reactivex_dagger.data.model.User;
import java.util.List;

/**
 * Created by tung on 5/30/17.
 */

public class ListUserViewModel extends BaseObservable {

    UserAdapter mAdapter;

    ListUserViewModel(UserAdapter adapter){
        mAdapter = adapter;
    }

    public UserAdapter getAdapter(){
        return mAdapter;
    }

}
