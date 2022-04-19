package com.powerhungers.fomezero.feature.producer.basket.domain.repository

import com.powerhungers.fomezero.domain.model.UserType
import com.powerhungers.fomezero.feature.producer.basket.domain.model.BasketType
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    fun basket(smallBasket: Boolean, medianBasket: Boolean, bigBasket: Boolean): Flow<BasketType>
}