package com.kitsu.android.anime.ui.modules.main.profile

import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment

class ProfileFragment: BaseFragment(){

    companion object {
        @JvmStatic fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_profile

}