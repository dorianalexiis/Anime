package com.kitsu.android.anime.ui.modules.mainpager

import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment

class MainPagerFragment : BaseFragment(){

    companion object {
        @JvmStatic fun newInstance(): MainPagerFragment {
            return MainPagerFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_main_pager


}