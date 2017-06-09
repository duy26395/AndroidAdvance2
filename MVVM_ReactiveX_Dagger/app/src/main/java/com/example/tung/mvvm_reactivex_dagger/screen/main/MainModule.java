package com.example.tung.mvvm_reactivex_dagger.screen.main;

import android.app.Activity;
import com.example.tung.mvvm_reactivex_dagger.data.api.GitHubApi;
import com.example.tung.mvvm_reactivex_dagger.data.model.UserRepository;
import com.example.tung.mvvm_reactivex_dagger.data.model.UserRepositoryImpl;
import com.example.tung.mvvm_reactivex_dagger.utils.dagger.ActivityScope;
import com.example.tung.mvvm_reactivex_dagger.utils.navigator.Navigator;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tung on 5/30/17.
 */

@Module
public class MainModule {

    private Activity mActivity;

    public MainModule(Activity activity){
        mActivity = activity;
    }

    @ActivityScope
    @Provides
    public UserRepository provideUserRepository(GitHubApi gitHubApi) {
        return new UserRepositoryImpl(gitHubApi);
    }

    @ActivityScope
    @Provides
    public Navigator provideNavigator() {
        return new Navigator(mActivity);
    }

    @ActivityScope
    @Provides
    public MainViewModel provideMainViewModel(UserRepository userRepository, Navigator navigator){
        return new MainViewModel(userRepository, navigator);
    }
}
