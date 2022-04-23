package com.powerhungers.fomezero.domain.di

import com.powerhungers.fomezero.domain.usecase.GetUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUserNameUseCase(repository = get())
    }
}