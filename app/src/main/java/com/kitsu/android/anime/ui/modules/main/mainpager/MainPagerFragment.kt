package com.kitsu.android.anime.ui.modules.main.mainpager

import android.os.Bundle
import android.view.View
import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.adapters.MainPagerAdapter
import com.kitsu.android.anime.ui.base.BaseFragment
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

        pvHome.adapter = MainPagerAdapter(childFragmentManager)

        navigation.setOnNavigationItemSelectedListener {
            when (it.getItemId()) {
                R.id.navigation_mainpager_home -> {
                    pvHome.currentItem = 0
                    true
                }
                R.id.navigation_mainpager_treding -> {
                    pvHome.currentItem = 1
                    true
                }
                R.id.navigation_mainpager_profile -> {
                    pvHome.currentItem = 2

                    true
                }
                else -> false
            }
        }
    }

}