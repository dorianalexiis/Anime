package com.kitsu.android.anime.api.controllers


import com.kitsu.android.anime.api.services.AnimeApi
import com.kitsu.android.anime.data.response.HomeResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeController(private val animeApi: AnimeApi) {

    fun getHome(limit:Int, offset:Int): Observable<HomeResponse> = animeApi.getHome(limit,offset)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    fun getDetail(slug: String?): Observable<HomeResponse>? {
        slug?.let {
            return animeApi.getDetail("slug,title", slug,
                    "categories,animeProductions.producer")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
        }
        return null
    }
}
