package com.powerhungers.fomezero.base_app.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

inline fun <V, reified U> V.useCase() where U : UseCase<*, *>, V : ViewModel, V : KoinComponent =
    inject<U> {
        parametersOf(viewModelScope)
    }