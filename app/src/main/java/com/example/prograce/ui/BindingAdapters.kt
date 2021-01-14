package com.example.prograce.ui

import android.net.Uri
import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.prograce.R

@BindingAdapter("android:loadImage")
fun loadImage(ib : ImageButton , uri : Uri?) {
    if (uri != null) {
        Glide.with(ib.context)
                .load(uri.buildUpon().scheme("https").build())
                .circleCrop()
                .into(ib)
    } else {
        Glide.with(ib.context)
                .load(R.drawable.default_profile_pic_foreground)
                .circleCrop()
                .apply(RequestOptions.circleCropTransform())
                .override(110)
                .into(ib)
    }
}
