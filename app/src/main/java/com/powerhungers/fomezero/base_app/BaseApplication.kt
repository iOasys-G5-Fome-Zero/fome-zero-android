package com.powerhungers.fomezero.base_app

import android.app.Application
import com.powerhungers.fomezero.data.di.dataLocalModule
import com.powerhungers.fomezero.data.remote.di.dataRemoteModule
import com.powerhungers.fomezero.feature.consumer.di.consumerModule
import com.powerhungers.fomezero.feature.login.di.loginModule
import com.powerhungers.fomezero.feature.registration.di.registrationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    dataRemoteModule,
                    dataLocalModule,
                    loginModule,
                    registrationModule,
                    consumerModule
                )
            )
        }.androidContext(applicationContext)
    }
}