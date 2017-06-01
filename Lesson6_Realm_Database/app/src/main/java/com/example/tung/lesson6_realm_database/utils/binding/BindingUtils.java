package com.example.tung.lesson6_realm_database.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.tung.lesson6_realm_database.screen.main.ViewPagerAdapter;

/**
 * Created by tung on 6/1/17.
 */

public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter("recyclerAdapter")
    public static void setAdapterRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void setAvatarUrl(ImageView view, String url){
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter("onEditorActionListener")
    public static void setOnEditorActionListener(TextView textView, TextView.OnEditorActionListener listener){
        textView.setOnEditorActionListener(listener);
    }


}
