package com.powerhungers.fomezero.feature.login.data.local

interface LoginLocalDataSource {
    fun savaAccessToken(token:String)
}