package com.example.tung.lesson6_realm_database.screen.users_saved_fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tung.lesson6_realm_database.R;
import com.example.tung.lesson6_realm_database.databinding.FragmentUsersSavedBinding;
import com.example.tung.lesson6_realm_database.utils.navigator.Navigator;

public class UsersSavedFragment extends Fragment {

    private static final String TAG = "UsersSavedFragment";

    private UserSavedAdapter mAdapter;
    private UsersSavedViewModel mViewModel;

    public UsersSavedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "---- onCreateView ----");
        FragmentUsersSavedBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_users_saved, container, false);
        mAdapter = new UserSavedAdapter();
        Navigator navigator = new Navigator(this);
        mViewModel = new UsersSavedViewModel(mAdapter, navigator);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isAdded()&&isVisibleToUser){
            mViewModel.loadAdapter();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onViewAttach();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "---- onDetach ----");
        super.onDetach();
        mViewModel.onViewDetach();
    }

    public UserSavedAdapter getAdapter(){
        return mAdapter;
    }
}
