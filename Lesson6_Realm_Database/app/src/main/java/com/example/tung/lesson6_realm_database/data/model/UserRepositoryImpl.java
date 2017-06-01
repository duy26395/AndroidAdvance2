package com.example.tung.lesson6_realm_database.data.model;

import android.support.annotation.NonNull;
import com.example.tung.lesson6_realm_database.data.api.GitHubApi;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by tung on 6/1/17.
 */

public class UserRepositoryImpl implements UserRepository{

    GitHubApi mGitHubApi;
    private static UserRepository instance;

    private UserRepositoryImpl(GitHubApi githubService) {
        mGitHubApi = githubService;
    }

    public static UserRepository getInstance(GitHubApi githubService) {
        if (instance == null) instance = new UserRepositoryImpl(githubService);
        return instance;
    }

    @Override
    public Observable<List<User>> searchUsers(String keyWord, int pageSize, int page) {
        return mGitHubApi.searchUsers(keyWord, pageSize, page)
                .flatMap(new Function<UserList, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull final UserList userList) throws Exception {
                        if (userList != null) return Observable.just(userList.getUsers());
                        else return Observable.error(new NullPointerException());
                    }
                });
    }
}
