package com.example.tung.mvvm_reactivex_dagger;

import android.content.Context;
import com.example.tung.mvvm_reactivex_dagger.utils.dagger.AppScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tung on 5/30/17.
 */

@Module
public class AppModule {

    Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @AppScope
    @Provides
    public Context provideApplicationContext(){
        return mContext;
    }
}
