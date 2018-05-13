package com.kitsu.android.anime.di.modules.fragments


import com.kitsu.android.anime.ui.modules.main.home.HomeFragment
import com.kitsu.android.anime.ui.modules.main.mainpager.MainPagerFragment
import com.kitsu.android.anime.ui.modules.main.profile.ProfileFragment
import com.kitsu.android.anime.ui.modules.main.treding.TredingFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideMainPagerFragmentFactory(): MainPagerFragment

    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideHomeFragmentFactory(): HomeFragment

    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideTredingFragmentFactory(): TredingFragment

    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideProfileFragmentFactory(): ProfileFragment

}
