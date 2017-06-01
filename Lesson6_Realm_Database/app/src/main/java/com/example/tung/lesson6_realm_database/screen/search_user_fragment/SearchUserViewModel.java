package com.example.tung.lesson6_realm_database.screen.search_user_fragment;

import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.example.tung.lesson6_realm_database.data.api.GitHubApi;
import com.example.tung.lesson6_realm_database.data.api.ServiceGenerator;
import com.example.tung.lesson6_realm_database.data.model.User;
import com.example.tung.lesson6_realm_database.data.model.UserRepository;
import com.example.tung.lesson6_realm_database.data.model.UserRepositoryImpl;
import com.example.tung.lesson6_realm_database.screen.BaseViewModel;
import com.example.tung.lesson6_realm_database.utils.navigator.Navigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import java.util.List;

/**
 * Created by tung on 6/1/17.
 */

public class SearchUserViewModel extends BaseViewModel
        implements SearchUserAdapter.OnRecyclerViewItemClickListener {

    private static final String TAG = "SearchUserViewModel";

    private String mKeyword;

    private SearchUserAdapter mAdapter;
    private Navigator mNavigator;
    private UserRepository mUserRepository;
    private Realm mRealm;

    public SearchUserViewModel(SearchUserAdapter adapter, Navigator navigator) {
        mAdapter = adapter;
        mAdapter.setClickListener(this);
        mNavigator = navigator;
        mUserRepository =
                UserRepositoryImpl.getInstance(ServiceGenerator.createService(GitHubApi.class));
    }

    @Bindable
    public String getKeyword() {
        return mKeyword;
    }

    public SearchUserAdapter getAdapter() {
        return mAdapter;
    }

    public TextView.OnEditorActionListener getOnEditorActionListener() { // bat su kien khi nhan phim Enter trong EditText
        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                searchUser();
                return true; // khong nhap Enter vao EditText
            }
        };
    }

    public void setKeyword(String keyword) {
        mKeyword = keyword;
    }

    public void onButtonSearchClicked(View v) {
        searchUser();
    }

    public void searchUser() {
        Disposable disposable = mUserRepository.searchUsers(mKeyword, 50, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        mAdapter.addAllItems(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.i(TAG, throwable.getMessage());
                    }
                });
        startSubscriber(disposable);
    }

    @Override
    public void onButtonSaveClicked(User user) {
//        Log.i("clickSave", "save user: " + user.getName());
        mNavigator.Toast("Saved user: " + user.getName());
        mRealm.beginTransaction();
        mRealm.insertOrUpdate(user);
        mRealm.commitTransaction();
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
}
