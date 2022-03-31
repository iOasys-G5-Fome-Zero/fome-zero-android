package com.powerhungers.fomezero.feature.login.domain.repository

import com.powerhungers.fomezero.feature.login.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(email: String, password: String): Flow<User>
}