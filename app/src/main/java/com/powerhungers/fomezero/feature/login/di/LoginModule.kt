package com.powerhungers.fomezero.feature.login.di

import com.powerhungers.fomezero.feature.login.data.local.LoginLocalDataSourceImpl
import com.powerhungers.fomezero.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.powerhungers.fomezero.feature.login.data.remote.service.LoginService
import com.powerhungers.fomezero.feature.login.data.repository.LoginRepositoryImpl
import com.powerhungers.fomezero.feature.login.domain.repository.LoginRepository
import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import com.powerhungers.fomezero.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule = module {

    factory<LoginRepository> {
        LoginRepositoryImpl(
            remoteDataSource = LoginRemoteDataSource(
                service = get<Retrofit>().create(LoginService::class.java)
            ),
            localDataSource = LoginLocalDataSourceImpl(get())
        )
    }

    viewModel {
        LoginViewModel(
            loginUseCase = LoginUseCase(
                repository = get()
            )
        )
    }
}