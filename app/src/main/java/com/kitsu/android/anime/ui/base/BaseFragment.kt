package com.kitsu.android.anime.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kitsu.android.anime.R
import dagger.android.support.AndroidSupportInjection

open class BaseFragment: Fragment(){

    private var activity: BaseActivity? = null
    protected var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as BaseActivity
    }

    open fun getFragmentLayoutResId(): Int = R.layout.fragment_base

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mView = inflater.inflate(getFragmentLayoutResId(), container, false)
        return mView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        initialize()
    }

    fun initialize() {
        AndroidSupportInjection.inject(this)
    }

    protected fun pushFragment(fragment: Fragment, container: Int= R.id.container,
                               addBackStack: Boolean = true) {
        activity?.pushFragment(fragment, container, addBackStack)
    }

    fun replaceFragment(fragment: Fragment) {
        activity?.pushFragment(fragment, addBackStack =  false)
    }

}