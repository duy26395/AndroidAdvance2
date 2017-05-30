package com.example.tung.lesson5_dagger2.data.model;

import android.support.annotation.NonNull;
import com.example.tung.lesson5_dagger2.data.api.GitHubApi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by tung on 5/29/17.
 */

public class UserRepositoryImpl implements UserRepository {

    private GitHubApi mGitHubApi;

    public UserRepositoryImpl(GitHubApi gitHubApi) {
        mGitHubApi = gitHubApi;
    }

    @Override
    public Observable<List<User>> getUsers(String keyWord, int pageSize, int page) {
        return mGitHubApi.searchUsers(keyWord, pageSize, page)
                .flatMap(new Function<UserList, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull UserList userList) throws Exception {
                        return Observable.just(userList.getUsers());
                    }
                });
    }
}
