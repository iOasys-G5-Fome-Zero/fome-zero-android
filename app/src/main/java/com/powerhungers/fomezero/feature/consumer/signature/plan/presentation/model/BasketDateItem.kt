package com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model

data class BasketDateItem(
    val title: String,
    val isChecked: Boolean
)

data class BasketDate(
    val list: List<BasketDateItem> = listOf(
        BasketDateItem(
            title = "Semanal",
            isChecked = false
        ),
        BasketDateItem(
            title = "Quinzenal",
            isChecked = false
        ),
    )
)
