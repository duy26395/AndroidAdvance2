package com.example.tung.lesson5_dagger2.data.model;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tung on 5/29/17.
 */

public interface UserRepository {

    Observable<List<User>> getUsers(String keyWord, int pageSize, int page);
}
