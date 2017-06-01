package com.example.tung.lesson6_realm_database.data.api;

import com.example.tung.lesson6_realm_database.data.model.UserList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tung on 6/1/17.
 */

public interface GitHubApi {

    @GET("search/users")
    Observable<UserList> searchUsers(@Query("q") String keyWord, @Query("per_page") int pageSize, @Query("page") int page);
}
