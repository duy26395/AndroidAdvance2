package com.example.tung.mvvm_reactivex_dagger.screen.main;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tung.mvvm_reactivex_dagger.MyApplication;
import com.example.tung.mvvm_reactivex_dagger.R;
import com.example.tung.mvvm_reactivex_dagger.databinding.ActivityMainBinding;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appComponent(((MyApplication) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.onStop();
    }
}
