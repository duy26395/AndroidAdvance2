package com.example.tung.mvvm_reactivex_dagger.utils.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

/**
 * Created by tung on 5/30/17.
 */

public class BindingUtils {

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
}
