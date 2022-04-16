package com.powerhungers.fomezero.feature.consumer.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState

class ConsumerSharedViewModel : ViewModel() {

    private val navigateToSignatureViewState = MutableLiveData<ViewState<Unit>>()

    val navigateToSignatureLiveData = navigateToSignatureViewState as LiveData<ViewState<Unit>>

    fun navigateToSignature(){
        navigateToSignatureViewState.postSuccess(Unit)
    }
}