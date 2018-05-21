package com.kitsu.android.anime.ui.modules.detail

import com.kitsu.android.anime.api.controllers.AnimeController
import com.kitsu.android.anime.data.response.HomeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailPresenter @Inject
constructor(var animeController: AnimeController) {

    var mView: DetailView? = null



    fun getDetailAnime(slug: String?) {
        animeController.getDetail(slug)
                ?.subscribe(
                        this::onSuccessDetail,
                        this::onFailure)
    }

    private fun onSuccessDetail(homeResponse: HomeResponse) {
        mView?.onShowData(homeResponse.data?.get(0))
    }

    private fun onFailure(throwable :Throwable ){
        mView?.onFailure()
    }
}