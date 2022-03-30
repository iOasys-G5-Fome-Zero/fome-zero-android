package com.powerhungers.fomezero.base_app.feature.login.domain.repository

import com.powerhungers.fomezero.base_app.feature.login.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>

}