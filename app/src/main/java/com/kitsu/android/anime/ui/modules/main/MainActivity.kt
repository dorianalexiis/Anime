package com.kitsu.android.anime.ui.modules.main

import android.os.Bundle
import com.kitsu.android.anime.ui.base.BaseActivity
import com.kitsu.android.anime.ui.modules.mainpager.MainPagerFragment

class MainActivity : BaseActivity() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        if (savedInstanceState == null){
            pushFragment(MainPagerFragment())
        }
    }

}
