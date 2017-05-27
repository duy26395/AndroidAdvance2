package com.example.tung.lesson4_reactivex.data.api;

import com.example.tung.lesson4_reactivex.data.model.UserList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tung on 5/26/17.
 */

public interface GithubService {

    @GET("search/users")
    Observable<UserList> searchUsers(@Query("q") String keyWord, @Query("per_page") int pageSize, @Query("page") int page);
}
