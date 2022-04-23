package com.powerhungers.fomezero.domain.usecase

import com.powerhungers.fomezero.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserNameUseCase(private val repository: UserRepository) {

    operator fun invoke ():Flow<String> = repository.getUserName()
}