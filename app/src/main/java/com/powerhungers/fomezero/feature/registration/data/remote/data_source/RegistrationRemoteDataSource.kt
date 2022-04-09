package com.powerhungers.fomezero.feature.registration.data.remote.data_source

import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationRequest
import com.powerhungers.fomezero.feature.registration.data.remote.model.RegistrationResponse
import com.powerhungers.fomezero.feature.registration.data.remote.service.RegistrationService
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegistrationRemoteDataSource(private val service: RegistrationService) {

    fun registerUser(registrationRequest: RegistrationRequest): Flow<RegistrationModel> = flow {
        val response = service.registerUser(registrationRequest)

        if (response.isSuccessful) {
            response.body()?.let { RegistrationResponse ->
                emit(RegistrationResponse.toDomain())
            }
        } else throw GenericException()
    }

    private fun RegistrationResponse.toDomain() = RegistrationModel(
        id = id.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        userType = userType.orEmpty(),
        email = email.orEmpty(),
        phone = phone.orEmpty(),
        cpf = cpf.orEmpty(),
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
    )
}
