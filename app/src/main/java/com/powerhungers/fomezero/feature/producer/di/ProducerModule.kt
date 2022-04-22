package com.powerhungers.fomezero.feature.producer.di

import com.powerhungers.fomezero.feature.producer.main.presentation.ProducerSharedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val producerModule = module {

    viewModel {
        ProducerSharedViewModel()
    }
}