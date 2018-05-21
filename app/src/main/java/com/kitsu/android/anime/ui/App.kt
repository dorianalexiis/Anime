package com.kitsu.android.anime.ui

import android.app.Activity
import android.app.Application
import com.kitsu.android.anime.di.components.DaggerAppComponent
import com.kitsu.android.anime.utils.Session
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject



class App: Application(), HasActivityInjector {

    @Inject
    @JvmField
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null


    override fun onCreate() {
        super.onCreate()
        Session.init(this)
        initializeInjector()
    }

    private fun initializeInjector(){
        val component = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? = activityDispatchingAndroidInjector

}