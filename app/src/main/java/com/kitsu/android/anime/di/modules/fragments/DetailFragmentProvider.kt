package com.kitsu.android.anime.di.modules.fragments

import com.kitsu.android.anime.ui.modules.test.BlankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentProvider{


    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideBlankFragmentFactory(): BlankFragment
}
