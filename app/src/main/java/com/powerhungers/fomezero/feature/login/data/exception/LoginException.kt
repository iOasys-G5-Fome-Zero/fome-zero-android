package com.powerhungers.fomezero.feature.login.data.exception

import com.powerhungers.fomezero.common.exception.DataSourceException

class EmptyTokenException : DataSourceException("Token vazio")
class EmptyRefreshTokenException : DataSourceException("Refresh Token vazio")
