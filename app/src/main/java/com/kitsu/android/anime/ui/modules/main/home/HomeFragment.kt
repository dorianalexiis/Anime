package com.kitsu.android.anime.ui.modules.main.home

import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment

class HomeFragment:BaseFragment(){

    companion object {
        @JvmStatic fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_home

}