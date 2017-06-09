package com.example.tung.mvvm_reactivex_dagger.data.model;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by tung on 5/30/17.
 */

public interface UserRepository {
    Observable<List<User>> searchUsers(String keyword, int pageSize, int page);
}
