package com.powerhungers.fomezero.feature.login.domain.usecase

import com.powerhungers.fomezero.common.exception.EmptyEmailException
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.feature.login.domain.model.User
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: LoginRepository) {

    operator fun invoke(email: String, password: String): Flow<User> = when {
        email.isBlank() -> flow { throw EmptyEmailException() }
        password.isBlank() -> flow { throw EmptyPasswordException() }
        else -> repository.login(email, password)
    }
}