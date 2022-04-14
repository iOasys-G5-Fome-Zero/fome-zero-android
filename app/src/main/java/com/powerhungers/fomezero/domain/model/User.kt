package com.powerhungers.fomezero.domain.model

import com.powerhungers.fomezero.data.remote.model.UserTypeResponse

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val userTypeResponse: UserTypeResponse,
    val email: String,
    val phone: String,
    val cpf: String,
    val createdAt: String,
    val updatedAt: String,
    val token: String,
    val refreshToken: String
)

enum class UserType(val value : String) {
    PRODUCER("producer"),
    CONSUMER("consumer")
}