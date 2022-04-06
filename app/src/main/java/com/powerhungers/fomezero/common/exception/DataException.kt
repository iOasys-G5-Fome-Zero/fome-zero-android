package com.powerhungers.fomezero.common.exception

open class DataSourceException(message: String, cause: Throwable? = null) :
    Exception(message, cause)

class GenericException():DataSourceException("Ocorreu um erro, tente novamente.")




