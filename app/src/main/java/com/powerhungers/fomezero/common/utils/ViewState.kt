package com.powerhungers.fomezero.common.utils

sealed class ViewState<out T> {

    data class Success<T>(val data: T): ViewState<T>()

    data class Error(val throwable: Throwable): ViewState<Nothing>()

    object Neutral: ViewState<Nothing>()

    object Loading: ViewState<Nothing>()

    object FinishLoading: ViewState<Nothing>()

}