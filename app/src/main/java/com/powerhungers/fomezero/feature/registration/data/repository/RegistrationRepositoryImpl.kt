package com.powerhungers.fomezero.feature.registration.data.repository

import com.powerhungers.fomezero.feature.registration.data.remote.data_source.RegistrationRemoteDataSource
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationModel
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationRequest
import com.powerhungers.fomezero.feature.registration.domain.repository.RegistrationRepository
import kotlinx.coroutines.flow.Flow

class RegistrationRepositoryImpl(
    private val remoteDataSource: RegistrationRemoteDataSource
) : RegistrationRepository {
    override fun registerUser(registrationRequest: RegistrationRequest): Flow<RegistrationModel> =
        remoteDataSource.registerUser(registrationRequest)
}
