package com.powerhungers.fomezero.feature.registration.data.remote.service

import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationRequest
import com.powerhungers.fomezero.feature.registration.data.remote.model.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationService {

    @POST("users/new-user")
    suspend fun registerUser(
        @Body registrationRequest: RegistrationRequest
    ): Response<RegistrationResponse>
}
