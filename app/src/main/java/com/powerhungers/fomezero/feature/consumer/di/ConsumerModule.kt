package com.powerhungers.fomezero.feature.consumer.di

import com.powerhungers.fomezero.feature.consumer.home.presentation.ConsumerHomeViewModel
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import com.powerhungers.fomezero.feature.consumer.profile.presentation.ProfileConsumerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val consumerModule = module {

    viewModel {
        ConsumerSharedViewModel()
    }

    viewModel {
        ConsumerHomeViewModel(getUserNameUseCase = get())
    }

    viewModel {
        ProfileConsumerViewModel(getUserNameUseCase = get())
    }
}