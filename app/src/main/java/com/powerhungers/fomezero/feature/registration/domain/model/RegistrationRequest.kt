package com.powerhungers.fomezero.feature.registration.domain.model

import com.google.gson.annotations.SerializedName

class RegistrationRequest(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("userType")
    val userType: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("password")
    val password: String
)