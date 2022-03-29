package com.powerhungers.fomezero.base_app.di

import com.powerhungers.fomezero.base_app.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel() }
}