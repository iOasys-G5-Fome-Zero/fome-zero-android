package com.powerhungers.fomezero.data.local.di

import com.powerhungers.fomezero.data.local.datasource.UserLocalDataSource
import com.powerhungers.fomezero.data.local.util.SharedPreferenceHelper
import com.powerhungers.fomezero.data.repository.UserRepositoryImpl
import com.powerhungers.fomezero.domain.repository.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferenceHelper(androidContext()) }

    factory {
        UserLocalDataSource(
            sharedPreferenceHelper = get()
        )
    }

    factory<UserRepository> {
        UserRepositoryImpl(
            localDataSource = get()
        )
    }
}