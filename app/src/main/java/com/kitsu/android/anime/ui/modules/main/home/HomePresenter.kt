package com.kitsu.android.anime.ui.modules.main.home

import com.kitsu.android.anime.api.controllers.AnimeController
import com.kitsu.android.anime.data.response.HomeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomePresenter @Inject
constructor(private val animeController: AnimeController) {
    val LIMIT:Int = 12

    var mView: HomeView? = null
    var offset:Int = 0
    var last: Int? = null

    fun getInitList() {
        animeController.getHome(LIMIT, 0)
                .subscribe(
                        this::onSuccessList,
                        this::onFailureList)
    }



    private fun onSuccessList(homeResponse: HomeResponse?) {
        homeResponse?.data?.let {
            mView?.loadData(it)
        }

        last = homeResponse?.links?.last?.let {
            it.substring(it.lastIndexOf("=")+1).toInt()
        }
    }

    private fun onSuccessListMore(homeResponse: HomeResponse?) {
        homeResponse?.data?.let {
            mView?.loadMore(it)
        }
    }

    private fun onFailureList(throwable :Throwable ){
        mView?.onFailure()
    }

    fun loadMore() {
        offset+= LIMIT
        last?.let {
            if(offset>=it){
                offset = it
            }
        }

        animeController.getHome(LIMIT, offset)
                .subscribe(
                        this::onSuccessListMore,
                        this::onFailureList)
    }
}
