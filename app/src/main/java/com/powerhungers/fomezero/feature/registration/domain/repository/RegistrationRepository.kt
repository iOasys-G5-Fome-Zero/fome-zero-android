package com.powerhungers.fomezero.feature.registration.domain.repository

import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationModel
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationRequest
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    fun registerUser(registrationRequest: RegistrationRequest): Flow<RegistrationModel>
}