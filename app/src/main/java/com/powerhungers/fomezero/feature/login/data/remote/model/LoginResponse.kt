package com.powerhungers.fomezero.feature.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("userType")
    val userType: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("cpf")
    val cpf: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,

)
