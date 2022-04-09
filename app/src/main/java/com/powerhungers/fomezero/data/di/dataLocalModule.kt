package com.powerhungers.fomezero.data.di

import com.powerhungers.fomezero.data.local.SharedPreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferenceHelper(androidContext()) }
}