package com.powerhungers.fomezero.feature.login.domain.repository

import com.powerhungers.fomezero.data.remote.model.UserType
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(phoneOrEmail: String, password: String): Flow<UserType>
}