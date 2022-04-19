package com.powerhungers.fomezero.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.exception.EmptyEmailException
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.common.extension.postError
import com.powerhungers.fomezero.common.extension.postLoading
import com.powerhungers.fomezero.common.extension.postNeutral
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<UserType>>()
    private val emailViewState = MutableLiveData<ViewState<Unit>>()
    private val passwordViewState = MutableLiveData<ViewState<Unit>>()

    val loginLiveData = loginViewState as LiveData<ViewState<UserType>>
    val emailLiveData = emailViewState as LiveData<ViewState<Unit>>
    val passwordLiveData = passwordViewState as LiveData<ViewState<Unit>>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password)
                .flowOn(Dispatchers.IO)
                .onStart { loginViewState.postLoading() }
                .catch { handleError(it) }
                .collect { loginViewState.postSuccess(it) }
        }
    }

    private fun handleError(throwable: Throwable) {
        when (throwable) {
            is EmptyEmailException ->
                emailViewState.postError(throwable)
            is EmptyPasswordException ->
                passwordViewState.postError(throwable)
            else ->
                loginViewState.postError(throwable)
        }
    }

    fun clearViewState() {
        loginViewState.postNeutral()
        emailViewState.postNeutral()
        passwordViewState.postNeutral()
    }
}