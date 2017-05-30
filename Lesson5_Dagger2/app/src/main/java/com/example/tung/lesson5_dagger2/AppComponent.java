package com.example.tung.lesson5_dagger2;

import android.content.Context;
import com.example.tung.lesson5_dagger2.data.api.GitHubApi;
import com.example.tung.lesson5_dagger2.data.api.GitHubModule;
import com.example.tung.lesson5_dagger2.utils.dagger.AppScope;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by tung on 5/29/17.
 */

@AppScope
@Component(modules = {AppModule.class, GitHubModule.class})
public interface AppComponent {
    Context applicationContext();

    GitHubApi gitHubApi();
}
