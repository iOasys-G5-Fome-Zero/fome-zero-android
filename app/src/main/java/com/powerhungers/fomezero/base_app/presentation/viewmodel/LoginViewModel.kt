package com.powerhungers.fomezero.base_app.presentation.viewmodel

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.base_app.domain.model.User
import com.powerhungers.fomezero.base_app.domain.usecases.LoginUseCases
import com.powerhungers.fomezero.base_app.util.*
import org.koin.core.KoinComponent

class LoginViewModel : ViewModel(), KoinComponent {

    private val loginUseCase: LoginUseCases by useCase()
//    private val _loggedUserViewState = MutableLiveData<ViewState<User>>()         ERRO
//    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<User>>

    fun login(email: String, password: String) {
        //_loggedUserViewState.postLoading()
        loginUseCase.invoke(
            LoginUseCases.Params(
                email = email,
                password = password
            )
        )
    }

    fun resetViewState() {
        //_loggedUserViewState.postNeutral()    ERRO
    }
}