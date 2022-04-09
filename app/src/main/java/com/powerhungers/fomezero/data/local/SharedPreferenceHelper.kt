package com.powerhungers.fomezero.data.local

import android.content.Context
import com.powerhungers.fomezero.common.utils.Constants

class SharedPreferenceHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE
    )

    fun saveString(key: String, value: String) = sharedPreferences.edit().run {
        putString(key, value)
        apply()
    }

    fun getString(key: String): String = sharedPreferences.getString(key, "") ?: ""
}