package com.kitsu.android.anime.di.modules.fragments;


import com.kitsu.android.anime.ui.modules.mainpager.MainPagerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentProvider {

    @ContributesAndroidInjector(modules = BaseFragmentModule.class)
    abstract MainPagerFragment provideMainPagerFragmentFactory();

}
