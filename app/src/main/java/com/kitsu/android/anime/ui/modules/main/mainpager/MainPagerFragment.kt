package com.kitsu.android.anime.ui.modules.main.mainpager

import android.os.Bundle
import android.view.View
import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment
import com.kitsu.android.anime.ui.modules.main.home.HomeFragment
import com.kitsu.android.anime.ui.modules.main.profile.ProfileFragment
import com.kitsu.android.anime.ui.modules.main.treding.TredingFragment
import kotlinx.android.synthetic.main.fragment_main_pager.*


class MainPagerFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(): MainPagerFragment {
            return MainPagerFragment()
        }
    }

    override fun getFragmentLayoutResId(): Int = R.layout.fragment_main_pager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation.setOnNavigationItemSelectedListener {
            when (it.getItemId()) {
                R.id.navigation_mainpager_home -> {
                    replaceFragment(HomeFragment.newInstance(), container = R.id.frame_container)
                    true
                }
                R.id.navigation_mainpager_treding -> {
                    replaceFragment(TredingFragment.newInstance(), container = R.id.frame_container)
                    true
                }
                R.id.navigation_mainpager_profile -> {
                    replaceFragment(ProfileFragment.newInstance(), container = R.id.frame_container)

                    true
                }
                else -> false
            }
        }
        savedInstanceState.let {
            replaceFragment(HomeFragment.newInstance(), container = R.id.frame_container)
        }
    }

}