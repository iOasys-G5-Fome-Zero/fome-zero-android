package com.powerhungers.fomezero.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.common.exception.EmptyPhoneException
import com.powerhungers.fomezero.common.extension.*
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<UserType>>()
    private val phoneViewState = MutableLiveData<ViewState<Unit>>()
    private val passwordViewState = MutableLiveData<ViewState<Unit>>()

    val loginLiveData = loginViewState as LiveData<ViewState<UserType>>
    val phoneLiveData = phoneViewState as LiveData<ViewState<Unit>>
    val passwordLiveData = passwordViewState as LiveData<ViewState<Unit>>

    fun login(phone: String, password: String) {
        viewModelScope.launch {
            loginUseCase(phone, password)
                .flowOn(Dispatchers.IO)
                .onStart { loginViewState.postLoading() }
                .catch { handleError(it) }
                .collect { loginViewState.postSuccess(it) }
        }
    }

    private fun handleError(throwable: Throwable) {
        when (throwable) {
            is EmptyPhoneException ->
                phoneViewState.postError(throwable)
            is EmptyPasswordException ->
                passwordViewState.postError(throwable)
            else ->
                loginViewState.postError(throwable)
        }
    }

    fun clearViewState() {
        loginViewState.postNeutral()
        phoneViewState.postNeutral()
        passwordViewState.postNeutral()
    }
}