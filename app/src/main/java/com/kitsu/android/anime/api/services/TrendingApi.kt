package com.kitsu.android.anime.api.services

import com.kitsu.android.anime.data.response.TrendingResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TrendingApi {

    @GET("trending/anime?limit=10")
    fun getTop10(): Observable<TrendingResponse>
}