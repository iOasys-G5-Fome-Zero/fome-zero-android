package com.powerhungers.fomezero.feature.consumer.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.extension.postLoading
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.domain.usecase.GetUserNameUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.*

class ConsumerHomeViewModel(private val getUserNameUseCase: GetUserNameUseCase) : ViewModel() {

    private val userNameViewState = MutableLiveData<ViewState<String>>()
    val userNameLiveData = userNameViewState as LiveData<ViewState<String>>

    init {
        getUserName()
    }

    private fun getUserName() {
        viewModelScope.launch {
            getUserNameUseCase()
                .flowOn(Dispatchers.IO)
                .onStart { userNameViewState.postLoading() }
                .collect { userNameViewState.postSuccess(it) }
        }
    }
}