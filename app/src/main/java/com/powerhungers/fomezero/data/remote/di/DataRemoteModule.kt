package com.powerhungers.fomezero.data.remote.di

import com.powerhungers.fomezero.BuildConfig
import com.powerhungers.fomezero.data.remote.network.WebServiceFactory.createWebService
import com.powerhungers.fomezero.data.remote.network.WebServiceFactory.providerOkhttpClient
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        createWebService(
            providerOkhttpClient(
                BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "debug"
            )
        )
    }
}