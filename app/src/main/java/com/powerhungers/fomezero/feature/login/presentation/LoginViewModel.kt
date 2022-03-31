package com.powerhungers.fomezero.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.extension.postError
import com.powerhungers.fomezero.common.extension.postLoading
import com.powerhungers.fomezero.common.extension.postNeutral
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.feature.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<Unit>>()
    val loginLiveData = loginViewState as LiveData<ViewState<Unit>>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginViewState.postLoading()

            loginUseCase(email, password)
                .flowOn(Dispatchers.IO)
                .onStart { loginViewState.postLoading() }
                .catch { loginViewState.postError(it) }
                .collect { loginViewState.postSuccess(Unit) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        loginViewState.postNeutral()
    }
}