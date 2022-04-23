package com.powerhungers.fomezero.feature.producer.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState

class ProducerSharedViewModel : ViewModel() {

    private val navigateToProducerHomeViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToBasketViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToFinancesViewState = MutableLiveData<ViewState<Unit>>()
    private val navigateToPaymentViewState = MutableLiveData<ViewState<Unit>>()

    val navigateToProducerHomeLiveData =
        navigateToProducerHomeViewState as LiveData<ViewState<Unit>>
    val navigateToBasketLiveData =
        navigateToBasketViewState as LiveData<ViewState<Unit>>
    val navigateToFinancesLiveData =
        navigateToFinancesViewState as LiveData<ViewState<Unit>>
    val navigateToPaymentLiveData =
        navigateToPaymentViewState as LiveData<ViewState<Unit>>

    fun navigateToFinances() {
        navigateToFinancesViewState.postSuccess(Unit)
    }

    fun navigateToProducerHome() {
        navigateToProducerHomeViewState.postSuccess(Unit)
    }

    fun navigateToBasket() {
        navigateToBasketViewState.postSuccess(Unit)
    }

    fun navigateToPayment() {
        navigateToPaymentViewState.postSuccess(Unit)
    }

}