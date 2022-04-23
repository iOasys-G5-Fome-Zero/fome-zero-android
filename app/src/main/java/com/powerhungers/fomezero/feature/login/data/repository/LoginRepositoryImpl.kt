package com.powerhungers.fomezero.feature.login.data.repository

import com.powerhungers.fomezero.data.local.datasource.UserLocalDataSource
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect

class LoginRepositoryImpl(
    private val remoteDataSource: LoginRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) : LoginRepository {

    override fun login(phoneOrEmail: String, password: String): Flow<UserType> = flow {
        remoteDataSource.login(phoneOrEmail, password).collect { userData ->
            localDataSource.saveUserData(userData = userData)

            emit(userData.userType)
        }
    }
}