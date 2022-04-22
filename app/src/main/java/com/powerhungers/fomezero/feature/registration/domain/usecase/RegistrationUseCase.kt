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
        email: String,
        phone: String,
        password: String,
        userType: String,

        ): Flow<RegistrationModel> = when {
        name.isBlank() -> flow { throw EmptyNameException() }
        email.isBlank() -> flow { throw EmptyEmailException() }
        phone.isBlank() -> flow { throw EmptyPhoneException() }
        password.isBlank() -> flow { throw EmptyPasswordException() }
        userType.isBlank() -> flow { throw EmptyUserTypeException() }

        else -> repository.registerUser(
            RegistrationRequest(
                firstName = name,
                email = email,
                phone = phone,
                password = password,
                userType = userType,
            )
        )
    }
}