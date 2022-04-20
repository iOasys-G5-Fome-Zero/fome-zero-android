package com.powerhungers.fomezero.feature.producer.basket.domain.repository

import com.powerhungers.fomezero.feature.producer.basket.domain.model.BasketType
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    fun saveBasket(basketType: BasketType): Flow<Unit>
}