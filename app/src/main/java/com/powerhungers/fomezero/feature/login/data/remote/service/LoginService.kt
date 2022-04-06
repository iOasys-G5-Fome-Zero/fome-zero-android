package com.powerhungers.fomezero.feature.login.data.remote.service

import com.powerhungers.fomezero.feature.login.data.remote.model.LoginRequest
import com.powerhungers.fomezero.feature.login.data.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("auth/login")
    suspend fun signIn(@Body loginRequest: LoginRequest): Response<LoginResponse>
}