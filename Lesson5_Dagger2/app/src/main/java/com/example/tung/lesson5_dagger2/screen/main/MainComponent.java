package com.example.tung.lesson5_dagger2.screen.main;

import com.example.tung.lesson5_dagger2.AppComponent;
import com.example.tung.lesson5_dagger2.utils.dagger.ActivityScope;
import dagger.Component;

/**
 * Created by tung on 5/29/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    MainContract.Presenter presenter();

    void inject(MainActivity activity);
}
