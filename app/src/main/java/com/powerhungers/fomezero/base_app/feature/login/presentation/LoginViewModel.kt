package com.powerhungers.fomezero.base_app.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.base_app.common.extension.postError
import com.powerhungers.fomezero.base_app.common.extension.postLoading
import com.powerhungers.fomezero.base_app.common.extension.postNeutral
import com.powerhungers.fomezero.base_app.common.extension.postSuccess
import com.powerhungers.fomezero.base_app.common.utils.ViewState
import com.powerhungers.fomezero.base_app.feature.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<Unit>>()
    val loginLiveData = loginViewState as LiveData<ViewState<Unit>>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginViewState.postLoading()

            loginUseCase(email, password)
                .flowOn(Dispatchers.IO)
                .catch {
                    loginViewState.postError(it)
                }.collect { loginViewState.postSuccess(Unit) }
        }
    }
    override fun onCleared() {
        super.onCleared()
        loginViewState.postNeutral()
    }
}