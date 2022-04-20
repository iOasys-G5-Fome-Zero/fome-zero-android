package com.powerhungers.fomezero.common.exception

private const val EMPTY_EMAIL = "Campo email vazio"
private const val EMPTY_PASSWORD = "Campo senha vazio"
private const val EMPTY_NAME = "Campo nome vazio"
private const val EMPTY_USER_TYPE = "Tipo do usuario não selecionado"
private const val EMPTY_CHECKBOX = "Nenhum campo selecionado"

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

sealed class ParamException(message: String, title: String? = null) :
    DomainException(message, title)

class EmptyEmailException : ParamException(EMPTY_EMAIL)
class EmptyPasswordException : ParamException(EMPTY_PASSWORD)
class EmptyNameException : ParamException(EMPTY_NAME)
class EmptyUserTypeException : ParamException(EMPTY_USER_TYPE)

class EmptyCheckboxException : ParamException(EMPTY_CHECKBOX)