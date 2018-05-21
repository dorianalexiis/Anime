package com.kitsu.android.anime.ui.modules.main.treding

import com.kitsu.android.anime.api.controllers.TrendingController
import com.kitsu.android.anime.data.response.TrendingResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrendingPresenter @Inject
    constructor(private val trendingController: TrendingController) {


    lateinit var mView: TrendingView

    fun getInitList() {
        trendingController.getTop10()
                .subscribe(
                this::onSuccessListMore,
                this::onFailureList)
    }

    private fun onSuccessListMore(tredingResponse: TrendingResponse) {
        tredingResponse.data?.let {
            mView.loadData(it)
        }
    }

    private fun onFailureList(throwable :Throwable ){
        mView.onFailure()
    }

}