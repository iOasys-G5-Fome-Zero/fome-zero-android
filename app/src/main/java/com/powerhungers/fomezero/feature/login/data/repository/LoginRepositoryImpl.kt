package com.powerhungers.fomezero.feature.login.data.repository

import com.powerhungers.fomezero.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.powerhungers.fomezero.feature.login.domain.model.User
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(private val remoteDataSource: LoginRemoteDataSource) : LoginRepository {

    override fun login(phoneOrEmail: String, password: String): Flow<User> =
        remoteDataSource.login(phoneOrEmail, password)
}