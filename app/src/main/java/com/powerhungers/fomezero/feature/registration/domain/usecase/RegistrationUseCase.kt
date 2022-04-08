package com.powerhungers.fomezero.feature.registration.domain.usecase

import com.powerhungers.fomezero.common.exception.MissInformationException
import com.powerhungers.fomezero.feature.login.domain.model.User
import com.powerhungers.fomezero.feature.registration.domain.model.Register
import com.powerhungers.fomezero.feature.registration.domain.repository.RegistrationRepository
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class RegistrationUseCase(private val repository: RegistrationRepository) {
    operator fun invoke(
        name: String, userType: String,
        email: String, password: String): Flow<User> = when {
        name.isBlank() -> flow { throw MissInformationException() }
        userType.isBlank() -> flow { throw MissInformationException() }
        email.isBlank() -> flow { throw MissInformationException() }
        password.isBlank() -> flow { throw MissInformationException() }
        else -> repository.registration(name, userType, email, password)

    }
}