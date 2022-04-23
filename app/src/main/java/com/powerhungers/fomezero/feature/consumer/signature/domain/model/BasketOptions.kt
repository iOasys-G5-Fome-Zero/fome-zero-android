package com.powerhungers.fomezero.feature.consumer.signature.domain.model

import com.powerhungers.fomezero.R

object BasketOptions {

    fun small() = listOf(
        FoodItem(
            name = R.string.spices,
            max = 1,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.vegetable,
            max = 2,
            min = 0,
            image = R.drawable.left_ong_image

        ),
        FoodItem(
            name = R.string.greens,
            max = 2,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.fruits,
            max = 2,
            min = 0,
            image = R.drawable.left_ong_image
        )
    )

    fun medium() = listOf(
        FoodItem(
            name = R.string.spices,
            max = 2,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.vegetable,
            max = 3,
            min = 0,
            image = R.drawable.left_ong_image

        ),
        FoodItem(
            name = R.string.greens,
            max = 3,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.fruits,
            max = 3,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.processed_foods,
            max = 1,
            min = 0,
            image = R.drawable.left_ong_image
        )
    )

    fun large() = listOf(
        FoodItem(
            name = R.string.spices,
            max = 3,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.vegetable,
            max = 4,
            min = 0,
            image = R.drawable.left_ong_image

        ),
        FoodItem(
            name = R.string.greens,
            max = 4,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.fruits,
            max = 4,
            min = 0,
            image = R.drawable.left_ong_image
        ),
        FoodItem(
            name = R.string.processed_foods,
            max = 1,
            min = 0,
            image = R.drawable.left_ong_image
        )
    )
}

