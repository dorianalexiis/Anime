package com.kitsu.android.anime.ui.modules.main.home

import com.kitsu.android.anime.data.response.DataItem

interface HomeView {
    fun loadData(list: MutableList<DataItem?>)
    fun loadMore(list: MutableList<DataItem?>)
    fun onFailure()
}