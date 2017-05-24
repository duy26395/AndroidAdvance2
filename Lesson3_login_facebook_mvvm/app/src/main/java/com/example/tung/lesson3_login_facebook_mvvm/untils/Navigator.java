package com.example.tung.lesson3_login_facebook_mvvm.untils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by tung on 5/23/17.
 */

public class Navigator {
    private Activity mActivity;

    public Activity getActivity() {
        return mActivity;
    }

    public Navigator(Activity activity) {
        mActivity = activity;
    }
    public void Toast( String test){
        Toast.makeText(mActivity,test,Toast.LENGTH_SHORT).show();
    }
    public void startActivity(Class <? extends Activity> clazz,Bundle bundle){
        Intent intent = new Intent(mActivity,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);

    }
}
