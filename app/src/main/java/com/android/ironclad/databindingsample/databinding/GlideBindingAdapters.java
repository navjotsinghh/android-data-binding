package com.android.ironclad.databindingsample.databinding;

import android.content.Context;
import android.widget.ImageView;

import com.android.ironclad.databindingsample.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.databinding.BindingAdapter;

class GlideBindingAdapters {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int imageUrl) {
        Context context = imageView.getContext();

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground);

        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageUrl)
                .into(imageView);

    }
}
