package com.example.tung.lesson3_login_facebook_mvvm.untils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by tung on 5/23/17.
 */

public final class BindingUtils  {
    private BindingUtils() {
    }

    @BindingAdapter("recyclerAdapter")
    public static void setAdapterRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
    @BindingAdapter("srcUrl")
    public static void setImageUrl(ImageView view, String url){
        Glide.with(view.getContext()).load(url).into(view);
    }
}
