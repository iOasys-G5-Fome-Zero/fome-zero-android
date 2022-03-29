package com.powerhungers.fomezero.base_app.domain.exception

sealed class LoginException(message: String= "", title: String? = null) :
    RuntimeException(message, RuntimeException(title))

class InvalidFieldException : LoginException("Erro")