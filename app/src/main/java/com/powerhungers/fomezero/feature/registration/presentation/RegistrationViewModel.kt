package com.powerhungers.fomezero.feature.registration.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase
import kotlinx.coroutines.launch

class RegistrationViewModel(private val registrationUseCase: RegistrationUseCase) : ViewModel() {

    fun registration(
        name: String, userType: String,
        email: String, password: String
    ) {viewModelScope.launch {
        registrationUseCase
    }

    }


}

