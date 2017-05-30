package com.example.tung.lesson5_dagger2.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by tung on 5/29/17.
 */

public class Navigator {

    private Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }

    private void startActivity(@NonNull Intent intent) {
        mActivity.startActivity(intent);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz) {
        Intent intent = new Intent(mActivity, clazz);
        startActivity(intent);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, Bundle args) {
        Intent intent = new Intent(mActivity, clazz);
        intent.putExtras(args);
        startActivity(intent);
    }

}
