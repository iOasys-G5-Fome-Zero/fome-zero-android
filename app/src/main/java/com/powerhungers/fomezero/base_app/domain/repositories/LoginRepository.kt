package com.powerhungers.fomezero.base_app.domain.repositories

import com.powerhungers.fomezero.base_app.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>

}