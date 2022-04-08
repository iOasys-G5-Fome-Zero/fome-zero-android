package com.powerhungers.fomezero.feature.registration.domain.repository

import com.powerhungers.fomezero.feature.registration.domain.model.Register
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    fun registration(name: String, userType: String,
                     email: String, password: String): Flow<Register>
}