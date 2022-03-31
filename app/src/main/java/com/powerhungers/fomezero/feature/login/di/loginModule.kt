package com.powerhungers.fomezero.feature.login.di

import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import com.powerhungers.fomezero.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    viewModel {
        LoginViewModel(
            loginUseCase = LoginUseCase(
                repository = get()
            )
        )
    }
}
//Uma sugestão é utilizar o get tipando o que irá ser injetado
//ex: get<LoginRepository>()