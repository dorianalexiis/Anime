package com.kitsu.android.anime.ui.modules.main.treding

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kitsu.android.anime.R
import com.kitsu.android.anime.data.response.DataItem
import com.kitsu.android.anime.ui.adapters.TrendingAdapter
import com.kitsu.android.anime.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_treding.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class TrendingFragment: BaseFragment(), TrendingView{

    @Inject
    @JvmField
    var trendingPresenter: TrendingPresenter?  = null

    companion object {
        @JvmStatic fun newInstance(): TrendingFragment {
            return TrendingFragment()
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_treding

    override fun initialize() {
        super.initialize()
        trendingPresenter?.let {
            it.mView = this@TrendingFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pgLoading.visibility = View.VISIBLE
        trendingPresenter?.getInitList()
    }

    override fun loadData(list: List<DataItem?>) {
        var adapter = TrendingAdapter(list)
        val linearLayout = LinearLayoutManager(context)
        rcTrending.layoutManager = linearLayout
        rcTrending.adapter = adapter
        pgLoading.visibility = View.GONE
    }

    override fun onFailure() {
        toast(R.string.error_connection)
        pgLoading.visibility = View.GONE
    }

}