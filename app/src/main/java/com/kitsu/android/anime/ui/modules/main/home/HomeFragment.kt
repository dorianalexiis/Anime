package com.kitsu.android.anime.ui.modules.main.home

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.kitsu.android.anime.R
import com.kitsu.android.anime.data.response.DataItem
import com.kitsu.android.anime.ui.adapters.HomeAdapter
import com.kitsu.android.anime.ui.base.BaseFragment
import com.kitsu.android.anime.utils.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class HomeFragment:BaseFragment(), HomeView{

    @Inject
    @JvmField
    var homePresenter: HomePresenter?  = null

    private lateinit var adapter: HomeAdapter

    companion object {
        @JvmStatic fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun initialize() {
        super.initialize()
        homePresenter?.let {
            it.mView = this@HomeFragment
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pgLoading.visibility = View.VISIBLE
        homePresenter?.getInitList()
    }


    override fun loadData(list: MutableList<DataItem?>) {
        adapter = HomeAdapter(list)
        val linearLayout = GridLayoutManager(context,3)
        rcHome.layoutManager = linearLayout
        rcHome.adapter = adapter
        rcHome.addOnScrollListener(object : EndlessRecyclerViewScrollListener(linearLayout){
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                   homePresenter?.loadMore()
            }
        })
        pgLoading.visibility = View.GONE
    }

    override fun loadMore(list: MutableList<DataItem?>) {
        adapter.list.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun onFailure() {
        toast(R.string.error_connection)
        pgLoading.visibility = View.GONE
    }
}