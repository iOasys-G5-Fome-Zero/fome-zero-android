package com.powerhungers.fomezero.common.extension

import androidx.lifecycle.MutableLiveData
import com.powerhungers.fomezero.common.utils.ViewState

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState.Success(data))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable) {
    postValue(ViewState.Error(error))
}

fun <T> MutableLiveData<ViewState<T>>.postNeutral() {
    postValue(ViewState.Neutral)
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState.Loading)
}

fun <T> MutableLiveData<ViewState<T>>.postFinishLoading() {
    postValue(ViewState.FinishLoading)
}
