package com.kitsu.android.anime.ui.modules.main

import android.os.Bundle
import com.android.dars.base.BaseInjectActivity
import com.kitsu.android.anime.ui.modules.main.mainpager.MainPagerFragment

class MainActivity : BaseInjectActivity() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        if (savedInstanceState == null){
            replaceFragment(MainPagerFragment.newInstance())
        }
    }

}
