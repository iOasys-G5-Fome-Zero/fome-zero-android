package com.lucasfagundes.ioasysbooks.common.exception

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

sealed class ParamException(message: String, title: String? = null) :
    DomainException(message, title)

class EmptyEmailException : ParamException("Campo email vazio")
class EmptyPasswordException : ParamException("Campo senha vazio")