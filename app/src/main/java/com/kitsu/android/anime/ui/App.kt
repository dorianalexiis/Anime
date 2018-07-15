package com.kitsu.android.anime.ui

import com.android.dars.base.BaseInjectApp
import com.kitsu.android.anime.di.components.DaggerAppComponent
import com.kitsu.android.anime.utils.Session



class App: BaseInjectApp() {

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

}