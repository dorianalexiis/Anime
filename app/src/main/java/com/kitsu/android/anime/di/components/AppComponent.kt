package com.kitsu.android.anime.di.components

import com.kitsu.android.anime.di.modules.ActivityBuilder
import com.kitsu.android.anime.di.modules.ApiModule
import com.kitsu.android.anime.di.modules.AppModule
import com.kitsu.android.anime.di.modules.ControllerModule
import com.kitsu.android.anime.ui.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class,
                        ApiModule::class, ControllerModule::class])
interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}
