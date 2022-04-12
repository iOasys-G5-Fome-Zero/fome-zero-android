package com.powerhungers.fomezero.feature.login.domain.usecase

import com.powerhungers.fomezero.common.exception.EmptyEmailException
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.data.remote.model.UserType
import com.powerhungers.fomezero.domain.model.User
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: LoginRepository) {

    operator fun invoke(email: String, password: String): Flow<UserType> = when {
        email.isBlank() -> flow { throw EmptyEmailException() }
        password.isBlank() -> flow { throw EmptyPasswordException() }
        else -> repository.login(email, password)
    }
}