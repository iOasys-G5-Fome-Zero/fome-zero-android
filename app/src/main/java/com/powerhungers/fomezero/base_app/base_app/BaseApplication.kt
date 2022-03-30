package com.powerhungers.fomezero.base_app.base_app

import android.app.Application
import com.powerhungers.fomezero.base_app.feature.login.di.loginModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
            loginModule
        )}
    }
}