package com.powerhungers.fomezero.base_app.domain.usecases

import com.powerhungers.fomezero.base_app.domain.core.UseCase
import com.powerhungers.fomezero.base_app.domain.exception.InvalidFieldException
import com.powerhungers.fomezero.base_app.domain.model.User
import com.powerhungers.fomezero.base_app.domain.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCases(
    private val loginRepository: LoginRepository,
    scope: CoroutineScope
) : UseCase<User, LoginUseCases.Params>(scope = scope) {

    override fun run(params: Params?): Flow<User> = when {
        params?.email.isNullOrEmpty() -> throw InvalidFieldException()
        params?.password.isNullOrEmpty() -> throw InvalidFieldException()
        else -> loginRepository.login(
            email = params?.email ?: "",
            password = params?.password ?: ""
        )
    }

    data class Params(
        val email: String,
        val password: String
    )
}