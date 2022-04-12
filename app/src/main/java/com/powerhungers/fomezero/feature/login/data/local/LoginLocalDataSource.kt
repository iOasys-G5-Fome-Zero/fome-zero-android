package com.powerhungers.fomezero.feature.login.data.local

import com.powerhungers.fomezero.data.local.SharedPreferenceHelper

private const val ACCESS_TOKEN_KEY = "accessToken"

class LoginLocalDataSource(private val sharedPreferenceHelper: SharedPreferenceHelper) {

    fun saveAccessToken(token: String) = sharedPreferenceHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = token
    )
}