package com.kitsu.android.anime.ui.modules.main.treding

import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment

class TredingFragment: BaseFragment(){

    companion object {
        @JvmStatic fun newInstance(): TredingFragment {
            return TredingFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_treding
}