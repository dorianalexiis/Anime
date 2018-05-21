package com.kitsu.android.anime.di.modules


import com.kitsu.android.anime.api.controllers.AnimeController
import com.kitsu.android.anime.api.controllers.TrendingController
import com.kitsu.android.anime.api.services.AnimeApi
import com.kitsu.android.anime.api.services.TrendingApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ControllerModule{

    @Provides
    @Singleton
    fun homeController(animeApi: AnimeApi):AnimeController = AnimeController(animeApi)

    @Provides
    @Singleton
    fun trendingController(trendingApi: TrendingApi):TrendingController = TrendingController(trendingApi)

}
