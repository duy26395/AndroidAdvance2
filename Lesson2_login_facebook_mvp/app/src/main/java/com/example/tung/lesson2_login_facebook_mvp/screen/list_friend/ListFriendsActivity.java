package com.example.tung.lesson2_login_facebook_mvp.screen.list_friend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.tung.lesson2_login_facebook_mvp.R;
import com.example.tung.lesson2_login_facebook_mvp.data.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 5/23/17.
 */

public class ListFriendsActivity extends AppCompatActivity implements ListFriendsContract.View {

    ListFriendsContract.Presenter mPresenter;
    FriendAdapter mAdapter;
    RecyclerView mRcvFriends;
    Button mBtnReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);
        initWidget();
    }

    @Override
    public void loadListFriendSuccess(List<Friend> friends) {
        mAdapter.addAllItems(friends);
    }

    private void initWidget() {

        mRcvFriends = (RecyclerView) findViewById(R.id.rcv_friends);
        mAdapter = new FriendAdapter(new ArrayList<Friend>());
        mRcvFriends.setAdapter(mAdapter);
        mRcvFriends.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new ListFriendsPresenter(this);
        mPresenter.loadListFriends();

        mBtnReload = (Button) findViewById(R.id.btn_reload);
        mBtnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadListFriends();
            }
        });
    }
}
