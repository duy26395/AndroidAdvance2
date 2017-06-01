package com.example.tung.lesson6_realm_database.data.model;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by tung on 6/1/17.
 */

public interface UserRepository {
    Observable<List<User>> searchUsers(String keyWord, int pageSize, int page);
}
