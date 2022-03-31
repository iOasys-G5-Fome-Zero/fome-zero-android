package com.powerhungers.fomezero.base_app

import android.app.Application
import com.powerhungers.fomezero.feature.login.di.loginModule
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                loginModule
            )
        }
    }
}