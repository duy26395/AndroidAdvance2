package com.example.tung.lesson4_reactivex.screen.main;

import android.util.Log;

import com.example.tung.lesson4_reactivex.data.model.User;
import com.example.tung.lesson4_reactivex.data.model.UserRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tung on 5/26/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private UserRepository mUserRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(MainContract.View v, UserRepository userRepository) {
        mMainView = v;
        mUserRepository = userRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void searchUsers(String keyWord, int pageSize, int page) {
        Disposable disposable = mUserRepository.searchUsers(keyWord, pageSize, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())      // chi dinh cac operator phia sau chay tren main thread, dam bao code update UI dc execute tren main Thread
                .subscribe(new Consumer<List<User>>() {     //onNext
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        Log.i("Thread runnning: ", Thread.currentThread().getName());
                        mMainView.searchSuccess(users);
                    }
//                }, new Consumer<Throwable>() {     //onError
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//
//                    }
//                }, new Action() {     //onComplete
//                    @Override
//                    public void run() throws Exception {
//
//                    }
//                }, new Consumer<Disposable>() {     //onSubscribe
//                    @Override
//                    public void accept(@NonNull Disposable disposable) throws Exception {
//
//                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
