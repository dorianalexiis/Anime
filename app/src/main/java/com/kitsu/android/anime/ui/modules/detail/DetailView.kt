package com.kitsu.android.anime.ui.modules.detail

import com.kitsu.android.anime.data.response.DataItem

interface DetailView {
    fun onFailure()
    fun onShowData(get: DataItem?)
}