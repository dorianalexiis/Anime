package com.kitsu.android.anime.api.controllers

import com.kitsu.android.anime.api.services.TrendingApi
import com.kitsu.android.anime.data.response.TrendingResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TrendingController(private val trendingApi: TrendingApi) {

    fun getTop10(): Observable<TrendingResponse> = trendingApi.getTop10()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}
