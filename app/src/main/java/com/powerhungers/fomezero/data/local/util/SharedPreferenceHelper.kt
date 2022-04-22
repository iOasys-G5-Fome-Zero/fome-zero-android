package com.powerhungers.fomezero.data.local.util

import android.content.Context

private const val SHARED_PREFERENCE_NAME = "com.powerhungers.fomezero.sharedprefenreces"

class SharedPreferenceHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE
    )

    fun saveString(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getString(key: String): String = sharedPreferences.getString(key, "") ?: ""
}