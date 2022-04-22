package com.powerhungers.fomezero.data.repository

import com.powerhungers.fomezero.data.local.datasource.UserLocalDataSource
import com.powerhungers.fomezero.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val localDataSource: UserLocalDataSource) : UserRepository {
    override fun getUserName(): Flow<String> = localDataSource.getUserName()

}