package com.example.tung.mvvm_reactivex_dagger;

import android.content.Context;
import com.example.tung.mvvm_reactivex_dagger.data.api.GitHubApi;
import com.example.tung.mvvm_reactivex_dagger.data.api.GitHubApiModule;
import com.example.tung.mvvm_reactivex_dagger.utils.dagger.AppScope;
import dagger.Component;

/**
 * Created by tung on 5/30/17.
 */

@AppScope
@Component(modules = { AppModule.class, GitHubApiModule.class })
public interface AppComponent {

    Context ApplicationContext();

    GitHubApi gitHubApi();
}
