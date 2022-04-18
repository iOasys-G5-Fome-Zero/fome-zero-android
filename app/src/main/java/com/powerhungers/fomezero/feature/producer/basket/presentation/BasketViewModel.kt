package com.powerhungers.fomezero.feature.producer.basket.presentation

import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.feature.producer.basket.domain.usecase.BasketUseCase
import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase

class BasketViewModel(private val basketUseCase: BasketUseCase) : ViewModel() {
}