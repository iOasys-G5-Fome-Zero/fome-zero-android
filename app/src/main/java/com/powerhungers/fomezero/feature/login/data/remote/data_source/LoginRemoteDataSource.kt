package com.powerhungers.fomezero.feature.login.data.remote.data_source

import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.feature.login.data.remote.model.LoginRequest
import com.powerhungers.fomezero.feature.login.data.remote.model.LoginResponse
import com.powerhungers.fomezero.feature.login.data.remote.service.LoginService
import com.powerhungers.fomezero.feature.login.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSource(private val service: LoginService) {

    fun login(phoneOrEmail: String, password: String): Flow<User> = flow {
        val response = service.signIn(LoginRequest(phoneOrEmail, password))

        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain())
            }
        } else throw GenericException()
    }

    private fun LoginResponse.toDomain() = User(
        id = id.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        userType = userType.orEmpty(),
        email = email.orEmpty(),
        phone = phone.orEmpty(),
        cpf = cpf.orEmpty(),
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
    )
}