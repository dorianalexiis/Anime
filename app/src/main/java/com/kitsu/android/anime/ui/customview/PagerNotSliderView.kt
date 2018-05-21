package com.kitsu.android.anime.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent


class PagerNotSliderView(context: Context, attrs: AttributeSet) : android.support.v4.view.ViewPager(context, attrs) {
    var isPagingEnabled: Boolean = false

    init {
        this.isPagingEnabled = false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onInterceptTouchEvent(event)
    }
}