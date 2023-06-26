package com.cranaya.inc.screens.admin.product.update

data class AdminProductUpdateState(
    val name: String = "",
    val description: String = "",
    val idCategory: String = "",
    val image1: String = "",
    val image2: String = "",
    val price: Double = 0.0,
    val imagesToUpdate: MutableList<Int> = mutableListOf()
)
