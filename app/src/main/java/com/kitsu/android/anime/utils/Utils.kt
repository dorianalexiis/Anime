package com.kitsu.android.anime.utils

import android.content.Context
import android.graphics.Bitmap
import android.support.annotation.DrawableRes
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.BitmapImageViewTarget
import org.jetbrains.anko.dip

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun Context.showImageRound(glide: RequestManager,
                         @DrawableRes placeholder: Int? = null,
                         @DrawableRes error: Int? = null,
                         imageView: ImageView, url: String?) {
    val glideR = glide.load(url)
            .asBitmap()

    placeholder?.let {
        glideR.placeholder(it)
    }
    error?.let {
        glideR.error(it)
    }
    glideR
            .dontAnimate()
            .centerCrop().into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap) {
                    val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(this@showImageRound.resources, resource)
                    circularBitmapDrawable.cornerRadius = dip(10).toFloat()
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
}


fun Context.showImageCircular(glide: RequestManager, @DrawableRes placeholder: Int,
                              @DrawableRes error: Int,
                              imageView: ImageView, url: String) {
    glide.load(url)
            .asBitmap()
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .centerCrop().into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap) {
                    val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(this@showImageCircular.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
}