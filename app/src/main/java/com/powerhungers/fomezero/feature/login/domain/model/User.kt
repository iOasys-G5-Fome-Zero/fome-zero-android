package com.powerhungers.fomezero.feature.login.domain.model

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val userType: String,
    val email: String,
    val phone: String,
    val cpf: String,
    val createdAt: String,
    val updatedAt: String,
    val token: String,
    val refresh_token : String
)

