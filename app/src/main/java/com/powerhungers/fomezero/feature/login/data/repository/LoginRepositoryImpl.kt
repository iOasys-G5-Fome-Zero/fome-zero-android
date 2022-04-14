package com.powerhungers.fomezero.feature.login.data.repository

import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.login.data.local.LoginLocalDataSource
import com.powerhungers.fomezero.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect

class LoginRepositoryImpl(
    private val remoteDataSource: LoginRemoteDataSource,
    private val localDataSource: LoginLocalDataSource
) : LoginRepository {

    override fun login(phoneOrEmail: String, password: String): Flow<UserType> = flow {
        remoteDataSource.login(phoneOrEmail, password).collect { userData ->
            localDataSource.saveAccessToken(token = userData.token)

            emit(userData.userType)
        }
    }
}