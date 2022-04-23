package com.powerhungers.fomezero.feature.consumer.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState

class ConsumerSharedViewModel : ViewModel() {

    private val navigateToConsumerHomeViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToSignaturePlanViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToSignatureItemViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToSignatureOrderViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToDonationViewState = MutableLiveData<ViewState<Unit>>()

    val navigateToConsumerHomeLiveData =
        navigateToConsumerHomeViewState as LiveData<ViewState<Unit>>
    val navigateToSignaturePlanLiveData =
        navigateToSignaturePlanViewState as LiveData<ViewState<Unit>>
    val navigateToSignatureItemLiveData =
        navigateToSignatureItemViewState as LiveData<ViewState<Unit>>
    val navigateToSignatureOrderLiveData =
        navigateToSignatureOrderViewState as LiveData<ViewState<Unit>>
    val navigateToDonationLiveData =
        navigateToDonationViewState as LiveData<ViewState<Unit>>

    fun navigateToConsumerHome() {
        navigateToConsumerHomeViewState.postSuccess(Unit)
    }

    fun navigateToSignaturePlan() {
        navigateToSignaturePlanViewState.postSuccess(Unit)
    }

    fun navigateToSignatureItem() {
        navigateToSignatureItemViewState.postSuccess(Unit)
    }

    fun navigateToSignatureOrder() {
        navigateToSignatureOrderViewState.postSuccess(Unit)
    }

    fun navigateToDonation() {
        navigateToDonationViewState.postSuccess(Unit)
    }
}