package com.example.tung.lesson5_dagger2.screen.main;

import android.app.Activity;

import com.example.tung.lesson5_dagger2.data.api.GitHubApi;
import com.example.tung.lesson5_dagger2.data.model.UserRepository;
import com.example.tung.lesson5_dagger2.data.model.UserRepositoryImpl;
import com.example.tung.lesson5_dagger2.utils.Navigator;

import com.example.tung.lesson5_dagger2.utils.dagger.ActivityScope;
import com.example.tung.lesson5_dagger2.utils.dagger.AppScope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tung on 5/29/17.
 */

@Module
public class MainModule {

    private MainContract.View mView;

    public MainModule(MainContract.View view) {
        this.mView = view;
    }

    @ActivityScope
    @Provides
    public MainContract.Presenter providePresenter(UserRepository userRepository) {
        MainContract.Presenter presenter = new MainPresenter(mView, userRepository);
        return presenter;
    }

    @ActivityScope
    @Provides
    public UserRepository provideUserRepository(GitHubApi gitHubApi) {
        return new UserRepositoryImpl(gitHubApi);
    }

    @ActivityScope
    @Provides
    public Navigator provideNavigator() {
        return new Navigator((Activity) mView);
    }
}
