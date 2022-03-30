package com.powerhungers.fomezero.base_app.feature.login.di

import com.powerhungers.fomezero.base_app.feature.login.domain.usecase.LoginUseCase
import com.powerhungers.fomezero.base_app.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(loginUseCase = LoginUseCase(repository = get(), get = get())) }
}

