package com.powerhungers.fomezero.feature.registration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.extension.postLoading
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(private val registrationUseCase: RegistrationUseCase) : ViewModel() {

    private val registrationViewState = MutableLiveData<ViewState<Unit>>()
    val registrationLiveData = registrationViewState as LiveData<ViewState<Unit>>

    fun registration(
        name: String, userType: String,
        email: String, password: String
    ) {
        viewModelScope.launch {
            registrationViewState.postLoading()

            registrationUseCase(name, userType, email, password)
                .flowOn(Dispatchers.IO)

        }
    }
}

