package com.powerhungers.fomezero.feature.registration.di

import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase
import com.powerhungers.fomezero.feature.registration.presentation.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registrationModule = module {

    viewModel { RegistrationViewModel(
        registrationUseCase = RegistrationUseCase(repository = get())
    ) }
}