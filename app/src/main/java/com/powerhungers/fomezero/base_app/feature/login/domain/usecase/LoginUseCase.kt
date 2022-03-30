package com.powerhungers.fomezero.base_app.feature.login.domain.usecase

import com.lucasfagundes.ioasysbooks.common.exception.EmptyEmailException
import com.lucasfagundes.ioasysbooks.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.base_app.feature.login.domain.model.User
import com.powerhungers.fomezero.base_app.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: LoginRepository, get: Any) {

    operator fun invoke(email: String, password: String): Flow<User> = when {
        email.isEmpty() -> flow { throw EmptyEmailException() }
        password.isEmpty() -> flow { throw EmptyPasswordException() }
        else -> repository.login(email, password)
    }
}