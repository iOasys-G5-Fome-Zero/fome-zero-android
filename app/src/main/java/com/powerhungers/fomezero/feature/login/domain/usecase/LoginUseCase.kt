package com.powerhungers.fomezero.feature.login.domain.usecase

import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.common.exception.EmptyPhoneException
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: LoginRepository) {

    operator fun invoke(phone: String, password: String): Flow<UserType> = when {
        phone.isBlank() -> flow { throw EmptyPhoneException() }
        password.isBlank() -> flow { throw EmptyPasswordException() }
        else -> repository.login(phone, password)
    }
}