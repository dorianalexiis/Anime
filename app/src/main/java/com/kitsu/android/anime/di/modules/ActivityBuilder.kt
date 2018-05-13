package com.kitsu.android.anime.di.modules

import com.kitsu.android.anime.di.modules.fragments.MainFragmentProvider
import com.kitsu.android.anime.ui.modules.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [BaseActivityModule::class, MainFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

}