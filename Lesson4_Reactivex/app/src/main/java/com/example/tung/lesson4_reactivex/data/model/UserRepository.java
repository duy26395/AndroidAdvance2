package com.example.tung.lesson4_reactivex.data.model;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tung on 5/26/17.
 */

public interface UserRepository {
    Observable<List<User>> searchUsers(String keyWord, int pageSize, int page);
}
