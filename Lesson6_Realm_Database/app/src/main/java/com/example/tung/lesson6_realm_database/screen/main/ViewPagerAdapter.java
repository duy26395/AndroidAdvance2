package com.example.tung.lesson6_realm_database.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.tung.lesson6_realm_database.screen.search_user_fragment.SearchUserFragment;
import com.example.tung.lesson6_realm_database.screen.users_saved_fragment.UsersSavedFragment;

/**
 * Created by tung on 6/1/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SearchUserFragment();
                break;
            case 1:
                fragment = new UsersSavedFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Search User";
                break;
            case 1:
                title = "Users Saved";
                break;
        }
        return title;
    }
}
