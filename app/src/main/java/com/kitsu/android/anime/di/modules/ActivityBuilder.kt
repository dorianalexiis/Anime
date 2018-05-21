package com.kitsu.android.anime.di.modules

import com.kitsu.android.anime.di.modules.fragments.DetailFragmentProvider
import com.kitsu.android.anime.di.modules.fragments.MainFragmentProvider
import com.kitsu.android.anime.ui.modules.detail.DetailActivity
import com.kitsu.android.anime.ui.modules.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [BaseActivityModule::class, MainFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [BaseActivityModule::class, DetailFragmentProvider::class])
    abstract fun bindDetailActivity(): DetailActivity

}