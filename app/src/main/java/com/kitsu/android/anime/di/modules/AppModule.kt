package com.kitsu.android.anime.di.modules

import android.content.Context
import com.kitsu.android.anime.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: App): Context = app
}