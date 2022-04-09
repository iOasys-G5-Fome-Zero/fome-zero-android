package com.powerhungers.fomezero.feature.registration.domain.model

data class RegistrationModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val userType: String,
    val email: String,
    val phone: String,
    val cpf: String,
    val createdAt: String,
    val updatedAt: String,
)