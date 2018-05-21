package com.kitsu.android.anime.api.services


import com.kitsu.android.anime.data.response.HomeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("anime")
    fun getHome(@Query("page[limit]") limit:Int, @Query("page[offset]") offset:Int): Observable<HomeResponse>

    @GET("anime")
    fun getDetail(@Query("fields[categories]") cateroies:String,
                  @Query("filter[slug]") slug:String,
                  @Query("include") include:String): Observable<HomeResponse>
}
