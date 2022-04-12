package com.powerhungers.fomezero.data.remote.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("user_type")
    val userType: UserType?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("cpf")
    val cpf: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("refresh_token")
    val refreshToken: String?
)

enum class UserType(val value: String) {
    @SerializedName("consumer")
    CONSUMER("consumer"),
    @SerializedName("producer")
    PRODUCER("producer"),
}