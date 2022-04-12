package com.powerhungers.fomezero.feature.login.data.remote.data_source

import com.powerhungers.fomezero.common.exception.EmptyUserTypeException
import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.data.remote.model.UserResponse
import com.powerhungers.fomezero.domain.model.User
import com.powerhungers.fomezero.feature.login.data.exception.EmptyRefreshTokenException
import com.powerhungers.fomezero.feature.login.data.exception.EmptyTokenException
import com.powerhungers.fomezero.feature.login.data.remote.model.LoginRequest
import com.powerhungers.fomezero.feature.login.data.remote.service.LoginService
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

    private fun UserResponse.toDomain() = when {
        token.isNullOrBlank() ->
            throw EmptyTokenException()
        refreshToken.isNullOrBlank() ->
            throw EmptyRefreshTokenException()
        userType == null || userType.value.isBlank() ->
            throw EmptyUserTypeException()
        else -> User(
            id = id.orEmpty(),
            firstName = firstName.orEmpty(),
            lastName = lastName.orEmpty(),
            userType = userType,
            email = email.orEmpty(),
            phone = phone.orEmpty(),
            cpf = cpf.orEmpty(),
            createdAt = createdAt.orEmpty(),
            updatedAt = updatedAt.orEmpty(),
            token = token,
            refreshToken = refreshToken
        )
    }
}