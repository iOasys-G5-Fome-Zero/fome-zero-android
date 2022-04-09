package com.powerhungers.fomezero.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.extension.*
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<Unit>>()
    val loginLiveData = loginViewState as LiveData<ViewState<Unit>>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password)
                .flowOn(Dispatchers.IO)
                .onStart { loginViewState.postLoading() }
                .onCompletion { loginViewState.postFinishLoading() }
                .catch { loginViewState.postError(it) }
                .collect { loginViewState.postSuccess(Unit) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        loginViewState.postNeutral()
    }
}