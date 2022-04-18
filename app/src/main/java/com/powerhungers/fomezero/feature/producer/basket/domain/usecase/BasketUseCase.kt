package com.powerhungers.fomezero.feature.producer.basket.domain.usecase

import com.powerhungers.fomezero.common.exception.EmptyEmailException
import com.powerhungers.fomezero.common.exception.EmptyPasswordException
import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.producer.basket.domain.model.BasketType
import com.powerhungers.fomezero.feature.producer.basket.domain.repository.BasketRepository
import com.powerhungers.fomezero.feature.registration.domain.model.RegistrationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BasketUseCase(private val repository: BasketRepository) {

    operator fun invoke(smallBasket: Boolean, medianBasket: Boolean, bigBasket: Boolean): Flow<BasketType> = when {
        smallBasket.equals(0) -> flow { throw GenericException() }
        else -> repository.basket(smallBasket, medianBasket, bigBasket)
    }

}