package com.powerhungers.fomezero.data.local.datasource

import com.google.gson.Gson
import com.powerhungers.fomezero.data.local.util.SharedPreferenceHelper
import com.powerhungers.fomezero.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val USER_DATA_KEY = "userData"

class UserLocalDataSource(private val sharedPreferenceHelper: SharedPreferenceHelper) {

    fun getUserName(): Flow<String> = flow { emit(getUserData().firstName) }

    fun saveUserData(userData: User) = sharedPreferenceHelper.saveString(
        key = USER_DATA_KEY,
        value = Gson().toJson(userData)
    )

    private fun getUserData() = Gson().fromJson(
        sharedPreferenceHelper.getString(USER_DATA_KEY),
        User::class.java
    )
}