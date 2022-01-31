package com.sunrisekcdevelopers.imageloading

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

interface ExternalImage {
    fun load(
        context: Context,
        imgSrc: String,
        targetView: ImageView,
        @DrawableRes placeholderImg: Int? = null,
        @DrawableRes errorImg: Int? = null
    )
}
// Improve architecture of this interface to support flexibility
class StandardGlideImage : ExternalImage {
    override fun load(
        context: Context,
        imgSrc: String,
        targetView: ImageView,
        placeholderImg: Int?,
        errorImg: Int?
    ) {
        val requestOptions = RequestOptions()
        placeholderImg?.let { requestOptions.placeholder(it) }
        errorImg?.let { requestOptions.error(it) }
        Glide.with(context)
            .load(imgSrc)
            .apply(requestOptions)
            .into(targetView)
    }
}