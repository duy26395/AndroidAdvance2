package com.example.tung.mvvm_reactivex_dagger.screen.list_user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.tung.mvvm_reactivex_dagger.R;
import com.example.tung.mvvm_reactivex_dagger.data.model.User;
import com.example.tung.mvvm_reactivex_dagger.databinding.ActivityListUserBinding;
import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {

    ListUserViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        UserAdapter mAdapter = new UserAdapter(users);
        mViewModel = new ListUserViewModel(mAdapter);

        ActivityListUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_user);
        binding.setViewModel(mViewModel);
    }
}
