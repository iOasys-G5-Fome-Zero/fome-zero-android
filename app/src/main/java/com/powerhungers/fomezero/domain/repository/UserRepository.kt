package com.powerhungers.fomezero.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserName(): Flow<String>
}