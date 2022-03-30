package com.powerhungers.fomezero.base_app.di

import com.powerhungers.fomezero.base_app.feature.login.domain.usecase.LoginUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        LoginUseCase(get(), get())
    }
}