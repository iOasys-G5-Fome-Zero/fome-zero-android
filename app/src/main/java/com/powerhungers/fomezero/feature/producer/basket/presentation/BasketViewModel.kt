package com.powerhungers.fomezero.feature.producer.basket.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.common.extension.postError
import com.powerhungers.fomezero.common.extension.postLoading
import com.powerhungers.fomezero.common.extension.postNeutral
import com.powerhungers.fomezero.common.extension.postSuccess
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.feature.producer.basket.domain.usecase.BasketUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class BasketViewModel(private val basketUseCase: BasketUseCase) : ViewModel() {

    private val basketViewState = MutableLiveData<ViewState<Unit>>()
    val basketLiveData = basketViewState as LiveData<ViewState<Unit>>

    fun basket(smallBasket: Boolean, medianBasket: Boolean, bigBasket: Boolean) {
        viewModelScope.launch {
            basketUseCase(smallBasket, medianBasket, bigBasket)
                .flowOn(Dispatchers.IO)
                .onStart { basketViewState.postLoading() }
                .catch { handleError(it) }
                .collect { basketViewState.postSuccess(Unit) }
        }
    }

    private fun handleError(throwable: Throwable) {
        when (throwable) {
            is GenericException ->
                basketViewState.postError(throwable)
            else ->
                basketViewState.postError(throwable)
        }
    }

    fun clearViewState() {
        basketViewState.postNeutral()
    }

}