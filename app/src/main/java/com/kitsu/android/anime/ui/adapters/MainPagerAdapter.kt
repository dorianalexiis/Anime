package com.kitsu.android.anime.ui.adapters


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kitsu.android.anime.ui.modules.main.home.HomeFragment
import com.kitsu.android.anime.ui.modules.main.profile.ProfileFragment
import com.kitsu.android.anime.ui.modules.main.treding.TrendingFragment


class MainPagerAdapter(private val fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return NUM_TABS
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            1 -> return TrendingFragment.newInstance()
            2 -> return ProfileFragment.newInstance()
        }
        return HomeFragment.newInstance()
    }

    companion object {
        val NUM_TABS = 3
    }

}
