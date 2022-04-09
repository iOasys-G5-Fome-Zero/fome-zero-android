package com.powerhungers.fomezero.common.exception

import com.powerhungers.fomezero.common.utils.Constants

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

sealed class ParamException(message: String, title: String? = null) :
    DomainException(message, title)

class EmptyEmailException : ParamException(Constants.EMPTY_EMAIL)
class EmptyPasswordException : ParamException(Constants.EMPTY_PASSWORD)
class EmptyNameException : ParamException(Constants.EMPTY_NAME)
class EmptyUserTypeException : ParamException(Constants.EMPTY_USER_TYPE)