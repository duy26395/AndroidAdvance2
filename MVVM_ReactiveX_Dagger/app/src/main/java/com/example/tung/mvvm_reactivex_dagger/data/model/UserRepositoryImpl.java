package com.example.tung.mvvm_reactivex_dagger.data.model;

import com.example.tung.mvvm_reactivex_dagger.data.api.GitHubApi;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by tung on 5/30/17.
 */

public class UserRepositoryImpl implements UserRepository {

    GitHubApi mGitHubApi;

    public UserRepositoryImpl(GitHubApi gitHubApi){
        mGitHubApi = gitHubApi;
    }

    @Override
    public Observable<List<User>> searchUsers(String keyword, int pageSize, int page) {
        return mGitHubApi.searchUsers(keyword, pageSize, page)
                .flatMap(new Function<UserList, ObservableSource<List<User>>>() {
                    @Override
                    public ObservableSource<List<User>> apply(@NonNull UserList userList) throws Exception {
                        return Observable.just(userList.getUsers());
                    }
                });
    }
}
