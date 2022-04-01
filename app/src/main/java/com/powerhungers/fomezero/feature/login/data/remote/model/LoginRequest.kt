package com.powerhungers.fomezero.feature.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("phoneOrEmail")
    val phoneOrEmail: String,
    @SerializedName("password")
    val password: String
)
