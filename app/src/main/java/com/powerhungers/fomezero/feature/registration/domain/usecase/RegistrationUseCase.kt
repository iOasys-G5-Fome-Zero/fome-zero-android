package com.powerhungers.fomezero.feature.registration.domain.usecase

import com.powerhungers.fomezero.common.exception.*
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationModel
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationRequest
import com.powerhungers.fomezero.feature.registration.domain.repository.RegistrationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegistrationUseCase(private val repository: RegistrationRepository) {
    operator fun invoke(
        name: String,
        userType: String,
        email: String,
        password: String
    ): Flow<RegistrationModel> = when {
        name.isBlank() -> flow { throw EmptyNameException() }
        userType.isBlank() -> flow { throw EmptyUserTypeException() }
        email.isBlank() -> flow { throw EmptyPhoneException() }
        password.isBlank() -> flow { throw EmptyPasswordException() }
        else -> repository.registerUser(
            RegistrationRequest(
                firstName = name,
                userType = userType,
                email = email,
                password = password
            )
        )
    }
}