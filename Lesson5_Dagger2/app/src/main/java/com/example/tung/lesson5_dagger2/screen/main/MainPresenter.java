package com.example.tung.lesson5_dagger2.screen.main;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.tung.lesson5_dagger2.data.model.User;
import com.example.tung.lesson5_dagger2.data.model.UserRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tung on 5/29/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private MainContract.View mMainView;
    private UserRepository mUserRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContract.View view, UserRepository userRepository){
        mMainView = view;
        mUserRepository = userRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void searchUsers(String keyWord, int pageSize, int page) {
        Disposable disposable = mUserRepository.getUsers(keyWord, pageSize, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        mMainView.onGetUsersSuccess(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: ", throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
