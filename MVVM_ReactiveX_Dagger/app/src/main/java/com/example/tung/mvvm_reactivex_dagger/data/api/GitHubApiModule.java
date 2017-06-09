package com.example.tung.mvvm_reactivex_dagger.data.api;

import android.app.Application;
import com.example.tung.mvvm_reactivex_dagger.BuildConfig;
import com.example.tung.mvvm_reactivex_dagger.utils.dagger.AppScope;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tung on 5/30/17.
 */

@Module
public class GitHubApiModule {
    private static final int CONNECTION_TIMEOUT = 60;
    private static final String BASE_URL = "https://api.github.com/";

    private Application mApplication;

    public GitHubApiModule(Application application){
        mApplication = application;
    }

    @AppScope
    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @AppScope
    @Provides
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @AppScope
    @Provides
    Interceptor provideInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @AppScope
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache, Interceptor interceptor) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.cache(cache);
        httpClientBuilder.addInterceptor(interceptor);
        httpClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            httpClientBuilder.addInterceptor(logging);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return httpClientBuilder.build();
    }

    @AppScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @AppScope
    @Provides
    GitHubApi provideGitHubApi(Retrofit retrofit) {
        return retrofit.create(GitHubApi.class);
    }
}
