package com.powerhungers.fomezero.feature.producer.basket.domain.usecase

import com.powerhungers.fomezero.common.exception.EmptyCheckboxException
import com.powerhungers.fomezero.common.exception.GenericException
import com.powerhungers.fomezero.feature.producer.basket.domain.model.BasketType
import com.powerhungers.fomezero.feature.producer.basket.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow

class BasketUseCase(private val repository: BasketRepository) {

    operator fun invoke(
            smallBasket: Boolean,
            mediumBasket: Boolean,
            bigBasket: Boolean
    ): Flow<Unit> {
        val basketType = when {
            !smallBasket && !mediumBasket && !bigBasket -> throw EmptyCheckboxException()
            smallBasket && !mediumBasket && !bigBasket -> BasketType.SMALL_BASKET
            !smallBasket && mediumBasket && !bigBasket -> BasketType.MEDIUM_BASKET
            !smallBasket && !mediumBasket && bigBasket -> BasketType.BIG_BASKET
            smallBasket && mediumBasket && !bigBasket -> BasketType.SMALL_AND_MEDIUM_BASKET
            smallBasket && !mediumBasket && bigBasket ->  BasketType.SMALL_AND_BIG_BASKET
            !smallBasket && mediumBasket && bigBasket -> BasketType.MEDIUM_AND_BIG_BASKET
            smallBasket && mediumBasket && bigBasket -> BasketType.ALL_BASKETS
            else -> throw GenericException()
        }
        return repository.saveBasket(basketType)
    }

}