package com.powerhungers.fomezero.base_app

import android.app.Application
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {}
    }
}