package com.kitsu.android.anime.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kitsu.android.anime.BuildConfig
import com.kitsu.android.anime.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import java.util.*
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    @JvmField
    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null

    protected var mTagFragments: ArrayList<String>? = null

    open fun getActivityLayoutResId(): Int = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        initialize()
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/circular-light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        mTagFragments = ArrayList<String>()
        setContentView(getActivityLayoutResId())
        onViewCreated(savedInstanceState)
    }

    open fun onViewCreated(savedInstanceState: Bundle?) {

    }

    open fun initialize() {
        AndroidInjection.inject(this)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun replaceFragment(fragment: Fragment) {
        pushFragment(fragment, addBackStack = false)
    }

    fun pushFragment(fragment: Fragment, container: Int = R.id.container, addBackStack: Boolean = true,
                     vararg animations: Int = intArrayOf()) {
        val transaction = supportFragmentManager.beginTransaction()
        val tag = fragment.javaClass.simpleName
        if (BuildConfig.DEBUG) {
            Log.d("FLOW", "Activity: " + javaClass.simpleName + " -> " +
                    "Fragment: " + fragment.javaClass.simpleName)
        }
        if (addBackStack) {
            transaction.addToBackStack(tag)
        }

        when (animations.size) {
            0 -> transaction.setCustomAnimations(
                    R.anim.push_show_in_simple,
                    R.anim.push_hidden_out_simple,
                    0,
                    0)
            1 -> {
            }
            2 -> transaction.setCustomAnimations(animations[0], animations[1], 0, 0)
            4 -> transaction.setCustomAnimations(animations[0], animations[1], animations[2], animations[3])
            else -> throw RuntimeException("Error with animations transaction")
        }


        transaction.replace(container, fragment, tag)
        try {
            transaction.commit()
        } catch (e: Exception) {
            return
        }
        mTagFragments?.let {
            if (it.size == 0 || addBackStack) {
                it.add(tag)
            } else if (it.size > 0) {
                it.set(it.size - 1, tag)
            }else{

            }
        }
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment>? = fragmentDispatchingAndroidInjector

}