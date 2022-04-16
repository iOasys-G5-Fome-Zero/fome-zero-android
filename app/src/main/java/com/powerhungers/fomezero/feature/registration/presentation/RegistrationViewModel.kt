package com.powerhungers.fomezero.feature.registration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.exception.EmptyEmailException
import com.powerhungers.fomezero.common.exception.EmptyNameException
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.common.exception.EmptyUserTypeException
import com.powerhungers.fomezero.common.extension.*
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.feature.registration.domain.usecase.RegistrationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RegistrationViewModel(private val registrationUseCase: RegistrationUseCase) : ViewModel() {

    private val registrationViewState = MutableLiveData<ViewState<Unit>>()
    private val nameViewState = MutableLiveData<ViewState<Unit>>()
    private val userTypeViewState = MutableLiveData<ViewState<Unit>>()
    private val emailViewState = MutableLiveData<ViewState<Unit>>()
    private val passwordViewState = MutableLiveData<ViewState<Unit>>()

    val registrationLiveData = registrationViewState as LiveData<ViewState<Unit>>
    val nameLiveData = nameViewState as LiveData<ViewState<Unit>>
    val userTypeLiveData = userTypeViewState as LiveData<ViewState<Unit>>
    val emailLiveData = emailViewState as LiveData<ViewState<Unit>>
    val passwordLiveData = passwordViewState as LiveData<ViewState<Unit>>

    fun registration(name: String, userType: String, email: String, password: String) {
        viewModelScope.launch {
            registrationUseCase(name, userType, email, password)
                .flowOn(Dispatchers.IO)
                .onStart { registrationViewState.postLoading() }
                .catch { handleError(it) }
                .collect { registrationViewState.postSuccess(Unit) }
        }
    }

    private fun handleError(throwable: Throwable) {
        when (throwable) {
            is EmptyNameException ->
                nameViewState.postError(throwable)
            is EmptyUserTypeException ->
                userTypeViewState.postError(throwable)
            is EmptyEmailException ->
                emailViewState.postError(throwable)
            is EmptyPasswordException ->
                passwordViewState.postError(throwable)
            else ->
                registrationViewState.postError(throwable)
        }
    }

    fun clearViewState() {
        registrationViewState.postNeutral()
        nameViewState.postNeutral()
        userTypeViewState.postNeutral()
        emailViewState.postNeutral()
        passwordViewState.postNeutral()
    }
}