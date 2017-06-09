package com.example.tung.mvvm_reactivex_dagger.screen.main;

import com.example.tung.mvvm_reactivex_dagger.AppComponent;
import com.example.tung.mvvm_reactivex_dagger.data.model.UserRepository;
import com.example.tung.mvvm_reactivex_dagger.utils.dagger.ActivityScope;
import com.example.tung.mvvm_reactivex_dagger.utils.navigator.Navigator;
import dagger.Component;

/**
 * Created by tung on 5/30/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    MainViewModel mainViewModel();

    void inject(MainActivity activity);
}

