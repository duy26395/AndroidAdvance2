package com.example.tung.mvvm_reactivex_dagger;

import android.app.Application;
import com.example.tung.mvvm_reactivex_dagger.data.api.GitHubApiModule;

/**
 * Created by tung on 5/30/17.
 */

public class MyApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getApplicationContext()))
                    .gitHubApiModule(new GitHubApiModule(this))
                    .build();
        }
        return mAppComponent;
    }
}
