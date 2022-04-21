package com.powerhungers.fomezero.feature.consumer.signature.plan.presentation.model

data class BasketSizeItem(
    val title: String,
    val description: String,
    val isChecked: Boolean
)

data class BasketSize(
    val list: List<BasketSizeItem> = listOf(
        BasketSizeItem(
            title = "Pequena - R$ 45,00",
            description = "1 tempero, 2 legumes, 2 verduras , 3 frutas",
            isChecked = false
        ),
        BasketSizeItem(
            title = "Média - R$ 70,00",
            description = "2 temperos, 3 legumes, 3 verduras, 3 frutas e 1 processado",
            isChecked = false
        ),
        BasketSizeItem(
            title = "Grande - R$90,00",
            description = "3 temperos, 4 legumes, 4 verduras, 4 frutas e 1 processado",
            isChecked = false
        )
    )
)
