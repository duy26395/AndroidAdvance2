package com.example.tung.lesson4_reactivex.data.model;

import android.util.Log;

import com.example.tung.lesson4_reactivex.data.api.GithubService;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tung on 5/26/17.
 */

public class UserRepositoryImpl implements UserRepository {

    GithubService mGithubService;
    private static UserRepository instance;

    private UserRepositoryImpl(GithubService githubService) {
        mGithubService = githubService;
    }

    public static UserRepository getInstance(GithubService githubService) {
        if (instance == null) instance = new UserRepositoryImpl(githubService);
        return instance;
    }

    @Override
    public Observable<List<User>> searchUsers(String keyWord, int pageSize, int page) {
        return mGithubService.searchUsers(keyWord, pageSize, page)
                .flatMap(new Function<UserList, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull final UserList userList) throws Exception {
                        if (userList != null) return Observable.just(userList.getUsers());
                        else return Observable.error(new NullPointerException());
                    }
                });
    }
}
