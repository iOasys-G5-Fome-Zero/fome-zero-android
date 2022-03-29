package com.powerhungers.fomezero.base_app.domain.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class UseCase<T, Params>(
    private val scope: CoroutineScope
) {

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onSuccess: (T) -> Unit = {},
        onError: ((Throwable)) -> Unit = {}
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                run(params = params).collect { response ->
                    withContext(Dispatchers.Main) {
                        onSuccess.invoke(response)
                    }
                }
            } catch (err: Exception) {
                withContext(Dispatchers.Main) {
                    onError.invoke(err)
                }
            }
        }
    }
}