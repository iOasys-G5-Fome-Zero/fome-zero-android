package com.powerhungers.fomezero.feature.producer.main.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState

class ProducerSharedViewModel : ViewModel() {

    private val navigateToFinancesViewState = MutableLiveData<ViewState<Unit>>()
    val navigateToFinancesLiveData = navigateToFinancesViewState as LiveData<ViewState<Unit>>

    fun navigateToFinances(){
        navigateToFinancesViewState.postSuccess(Unit)
    }
}