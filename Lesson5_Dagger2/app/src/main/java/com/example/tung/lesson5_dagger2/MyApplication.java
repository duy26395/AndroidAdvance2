package com.example.tung.lesson5_dagger2;

import android.app.Application;
import com.example.tung.lesson5_dagger2.data.api.GitHubModule;

/**
 * Created by tung on 5/29/17.
 */

public class MyApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getApplicationContext()))
                    .gitHubModule(new GitHubModule(this))
                    .build();
        }
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
