package com.kitsu.android.anime.ui.modules.main

import android.os.Bundle
import com.kitsu.android.anime.ui.base.BaseActivity
import com.kitsu.android.anime.ui.modules.main.mainpager.MainPagerFragment

class MainActivity : BaseActivity() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        if (savedInstanceState == null){
            replaceFragment(MainPagerFragment.newInstance())
        }
    }

}
