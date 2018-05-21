package com.kitsu.android.anime.utils

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.kitsu.android.anime.R


object Session {

    private val SESSION_PREFERENCES = "sessionData"
    private val KEY_USER_NAME = "userName"
    private lateinit var preferences: SharedPreferences

    var userName: String? = null
        set(userName_) {
            save(KEY_USER_NAME, userName_)
            field = userName_
        }

    fun init(context: Context) {
        preferences = context.applicationContext.getSharedPreferences(SESSION_PREFERENCES,
                Context.MODE_PRIVATE)

        userName = preferences.getString(KEY_USER_NAME, context.getString(R.string.profile_insertyourname))
    }

    private fun save(key: String, value: Any?) {
        val editor = preferences.edit()

        value?.let {
            if (value is String) {
                editor.putString(key, value.toString())
            } else {
                editor.putString(key, Gson().toJson(value))
            }
            editor.apply()
        }
    }

    private fun save(key: String, value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

}
