package com.cranaya.domain.shoppingBag.usecase

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllUseCase,
    val findById: FindByIdUseCase,
    val getTotal: GetTotalUseCase
)
