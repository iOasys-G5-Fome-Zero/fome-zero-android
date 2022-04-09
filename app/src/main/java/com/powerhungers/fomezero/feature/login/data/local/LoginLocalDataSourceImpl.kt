package com.powerhungers.fomezero.feature.login.data.local

import com.powerhungers.fomezero.common.utils.Constants.ACCESS_TOKEN_KEY
import com.powerhungers.fomezero.data.local.SharedPreferenceHelper

class LoginLocalDataSourceImpl(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    LoginLocalDataSource {

    override fun savaAccessToken(token: String) = sharedPreferenceHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = token
    )
}