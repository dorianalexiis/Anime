package com.kitsu.android.anime.ui.modules.main.profile

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.kitsu.android.anime.R
import com.kitsu.android.anime.ui.base.BaseFragment
import com.kitsu.android.anime.utils.Session
import com.kitsu.android.anime.utils.showImageCircular
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: BaseFragment(){

    companion object {
        @JvmStatic fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_profile


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvUserName.text = Session.userName

        context?.showImageCircular(Glide.with(this),R.drawable.profile_userplaceholder_original,
                R.drawable.profile_faileduserplaceholder_original, ivAvatar, "")

    }

}