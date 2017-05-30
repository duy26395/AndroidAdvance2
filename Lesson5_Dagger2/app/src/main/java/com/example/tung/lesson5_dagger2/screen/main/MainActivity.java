package com.example.tung.lesson5_dagger2.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.tung.lesson5_dagger2.MyApplication;
import com.example.tung.lesson5_dagger2.R;
import com.example.tung.lesson5_dagger2.data.api.GitHubModule;
import com.example.tung.lesson5_dagger2.data.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainContract.Presenter mPresenter;

    private EditText mTextSearch;
    private Button mButtonSearch;
    private RecyclerView mRecyclerUsers;
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .appComponent(((MyApplication) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        mRecyclerUsers = (RecyclerView) findViewById(R.id.recycler_users);
        mAdapter = new UserAdapter(new ArrayList<User>());
        mRecyclerUsers.setAdapter(mAdapter);
        mRecyclerUsers.setLayoutManager(new LinearLayoutManager(this));

        mTextSearch = (EditText) findViewById(R.id.text_search);
        mButtonSearch = (Button) findViewById(R.id.button_search);
        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.searchUsers(mTextSearch.getText().toString().trim(), 20, 1);
            }
        });
        mTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // bat su kien khi nhan phim Enter trong EditText
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                mPresenter.searchUsers(mTextSearch.getText().toString().trim(), 20, 1);
                return true; // khong nhap Enter vao EditText
            }
        });

    }

    @Override
    public void onGetUsersSuccess(List<User> users) {
        mAdapter.addAllItems(users);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onStop();
    }
}
