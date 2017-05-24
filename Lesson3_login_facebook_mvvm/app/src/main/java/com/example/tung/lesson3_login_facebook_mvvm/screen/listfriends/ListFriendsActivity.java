package com.example.tung.lesson3_login_facebook_mvvm.screen.listfriends;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.tung.lesson3_login_facebook_mvvm.R;
import com.example.tung.lesson3_login_facebook_mvvm.databinding.ActivityListFriendsBinding;

public class ListFriendsActivity extends AppCompatActivity {

    private ListFriendViewModel mViewModel;
    private Button mBtnReload;
    private FriendAdapter mAdapter;
    private RecyclerView mRcvFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListFriendsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_friends);

        mAdapter = new FriendAdapter();
        mViewModel = new ListFriendViewModel(mAdapter);
        binding.setViewModel(mViewModel);

        mRcvFriends = (RecyclerView) findViewById(R.id.rcv_friends);
        mRcvFriends.setAdapter(mAdapter);
        mRcvFriends.setLayoutManager(new LinearLayoutManager(this));


    }
}
