package com.powerhungers.fomezero.base_app.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState.Success(data))
}