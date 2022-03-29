package com.powerhungers.fomezero.base_app.di

import com.powerhungers.fomezero.base_app.domain.usecases.LoginUseCases
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        LoginUseCases(get(), get())
    }
}