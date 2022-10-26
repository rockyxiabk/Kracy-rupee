package com.great.cash.rupee.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions
import com.great.cash.rupee.R

private fun load(ctx: Context, url: String): RequestBuilder<Drawable> {
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    return Glide.with(ctx).load(url)
}

private fun load(ctx: Context, drawable: Drawable): RequestBuilder<Drawable> {
            //--------------------------kotlin junk code-----------------------------
            try {
                var key_params = 0
                val sign_params = "60659917de4a798141b9f1a0btwtqownbpkyxfk6he4f"
                val time_key = "x82jxmztlxnge8bk457127d59926f1daf371b946ab39"
                if (sign_params.length == time_key.length) {
                    val each_key = hashMapOf<String, Any>()
                    val each_value = sign_params.toList()
                    val each_name = time_key.toList()
                    for ((index, str) in each_value.withIndex()) {
                        each_key["key_$str"] = each_name[index]
                    }
                    val keys = each_key.keys
                    val values = each_key.values
                    key_params += keys.size + values.size
                }
            } catch (eKotlinCode7: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    return Glide.with(ctx).load(drawable)
}


fun load(
    ctx: Context,
    url: String,
    imageView: ImageView?
) {
    load(ctx, url).placeholder(R.drawable.shape_round_bg)
        .error(R.drawable.ic_error_article)
        .into(imageView!!)
}

fun loadCircle(
    ctx: Context,
    drawable: Drawable,
    imageView: ImageView?
) {
    load(ctx, drawable).placeholder(R.drawable.shape_round_bg)
        .apply(RequestOptions.circleCropTransform())
        .error(R.drawable.ic_error_article)
        .into(imageView!!)
}
