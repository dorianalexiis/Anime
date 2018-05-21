package com.kitsu.android.anime.ui.modules.main.treding

import com.kitsu.android.anime.data.response.DataItem

interface TrendingView {
    fun loadData(it: List<DataItem?>)
    fun onFailure()
}