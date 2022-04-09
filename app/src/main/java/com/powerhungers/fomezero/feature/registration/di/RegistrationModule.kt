package com.powerhungers.fomezero.feature.registration.di

import com.powerhungers.fomezero.feature.registration.data.remote.data_source.RegistrationRemoteDataSource
import com.powerhungers.fomezero.feature.registration.data.remote.service.RegistrationService
import com.powerhungers.fomezero.feature.registration.data.repository.RegistrationRepositoryImpl
import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase
import com.powerhungers.fomezero.feature.registration.presentation.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val registrationModule = module {

    viewModel {
        RegistrationViewModel(
            registrationUseCase = RegistrationUseCase(
                repository = RegistrationRepositoryImpl(
                    remoteDataSource = RegistrationRemoteDataSource(
                        service = get<Retrofit>().create(RegistrationService::class.java)
                    )
                )
            )
        )
    }
}