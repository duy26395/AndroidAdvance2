package com.example.tung.lesson6_realm_database.screen.search_user_fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tung.lesson6_realm_database.R;
import com.example.tung.lesson6_realm_database.databinding.FragmentSearchUserBinding;
import com.example.tung.lesson6_realm_database.utils.navigator.Navigator;

public class SearchUserFragment extends Fragment {

    private static final String TAG = "SearchUserFragment";

    SearchUserViewModel mViewModel;
    SearchUserAdapter mAdapter;

    public SearchUserFragment() {
        // Required empty public constructor
    }

    public SearchUserAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.i(TAG, "---- onCreateView ----");
        FragmentSearchUserBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_search_user, container, false);
        mAdapter = new SearchUserAdapter();
        Navigator navigator = new Navigator(this);
        mViewModel = new SearchUserViewModel(mAdapter, navigator);
        View v = binding.getRoot();
        binding.setViewModel(mViewModel);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onViewAttach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mViewModel.onViewDetach();
    }
}
