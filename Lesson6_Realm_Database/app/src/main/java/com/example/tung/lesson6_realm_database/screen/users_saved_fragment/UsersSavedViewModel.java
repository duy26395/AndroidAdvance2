package com.example.tung.lesson6_realm_database.screen.users_saved_fragment;

import android.util.Log;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.screen.BaseViewModel;
import com.example.tung.lesson6_realm_database.utils.navigator.Navigator;
import io.realm.Realm;

/**
 * Created by tung on 6/1/17.
 */

public class UsersSavedViewModel extends BaseViewModel implements
        UserSavedAdapter.OnRecyclerViewItemClickListener {

    private UserSavedAdapter mAdapter;
    private Navigator mNavigator;

    private Realm mRealm;

    public UsersSavedViewModel(UserSavedAdapter adapter, Navigator navigator){
        mAdapter = adapter;
        mAdapter.setClickListener(this);
        mNavigator = navigator;
    }

    public UserSavedAdapter getAdapter(){
        loadAdapter();
        return mAdapter;
    }

    public void loadAdapter(){
        Log.i("loadUser","loaddddddddddddddddddddddddddddd");
        mAdapter.addAllItems(mRealm.where(User.class).findAll());
    }

    @Override
    public void onViewAttach() {
        super.onViewAttach();
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void onViewDetach() {
        super.onViewDetach();
        mRealm.close();
    }

    @Override
    public void onButtonDeleteClicked(User user) {
//        Log.i("clickDelete", "delete user: " + user.getName());
        mNavigator.Toast("Deleted user: " + user.getName());
        mAdapter.removeItem(user);
        mRealm.beginTransaction();
        user.deleteFromRealm();
        mRealm.commitTransaction();
    }
}
