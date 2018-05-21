package com.kitsu.android.anime.di.modules


import com.kitsu.android.anime.api.services.AnimeApi
import com.kitsu.android.anime.api.services.TrendingApi
import com.kitsu.android.anime.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApiModule {

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okhttp = OkHttpClient.Builder()

        val client = okhttp
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constants.base_url)
                .build()
    }

    @Provides
    @Singleton
    fun providerHomeApi(retrofit: Retrofit): AnimeApi = retrofit.create(AnimeApi::class.java)

    @Provides
    @Singleton
    fun providerTrendingApi(retrofit: Retrofit): TrendingApi = retrofit.create(TrendingApi::class.java)

}
