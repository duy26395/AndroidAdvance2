package com.example.tung.mvvm_reactivex_dagger.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import com.example.tung.mvvm_reactivex_dagger.data.model.User;
import com.example.tung.mvvm_reactivex_dagger.data.model.UserRepository;
import com.example.tung.mvvm_reactivex_dagger.screen.list_user.ListUserActivity;
import com.example.tung.mvvm_reactivex_dagger.utils.navigator.Navigator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/30/17.
 */

public class MainViewModel extends BaseObservable{

    private static final String TAG = "MainViewModel";

    private UserRepository mUserRepository;
    private Navigator mNavigator;
    private CompositeDisposable mCompositeDisposable;

    private String mKeyword, mLimit;

    public MainViewModel(UserRepository userRepository, Navigator navigator){
        mUserRepository = userRepository;
        mNavigator = navigator;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Bindable
    public String getKeyword() {
        return mKeyword;
    }

    public void setKeyword(String keyword){
        mKeyword = keyword;
    }

    @Bindable
    public String getLimit() {
        return mLimit;
    }

    public void setLimit(String limit){
        mLimit = limit;
    }

    public void onSearchButtonClicked(View v){
        searchUsers(mKeyword, Integer.parseInt(mLimit), 1);
    }

    public void searchUsers(String keyword, int pageSize, int page){
        Disposable disposable = mUserRepository.searchUsers(keyword,pageSize, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("users",
                                (ArrayList<? extends Parcelable>) users);
                        mNavigator.startActivity(ListUserActivity.class, bundle);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.i(TAG, throwable.getMessage());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public void onStop(){
        mCompositeDisposable.clear();
    }
}
