package com.example.tung.lesson5_dagger2;

import android.content.Context;
import com.example.tung.lesson5_dagger2.utils.dagger.AppScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tung on 5/29/17.
 */

@Module
public class AppModule {

    private Context mContext;


    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @AppScope
    public Context provideApplicationContext() {
        return mContext;
    }

}
