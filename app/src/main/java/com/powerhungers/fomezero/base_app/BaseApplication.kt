package com.powerhungers.fomezero.base_app

import android.app.Application
import com.powerhungers.fomezero.data.local.di.dataLocalModule
import com.powerhungers.fomezero.data.remote.di.dataRemoteModule
import com.powerhungers.fomezero.domain.di.domainModule
import com.powerhungers.fomezero.feature.consumer.di.consumerModule
import com.powerhungers.fomezero.feature.login.di.loginModule
import com.powerhungers.fomezero.feature.producer.di.producerModule
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
                    domainModule,
                    loginModule,
                    registrationModule,
                    consumerModule,
                    producerModule
                )
            )
        }.androidContext(applicationContext)
    }
}