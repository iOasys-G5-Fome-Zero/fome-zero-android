package com.powerhungers.fomezero.base_app.feature.login

sealed class LoginException(message: String= "", title: String? = null) :
    RuntimeException(message, RuntimeException(title))

class InvalidFieldException : LoginException("Erro")