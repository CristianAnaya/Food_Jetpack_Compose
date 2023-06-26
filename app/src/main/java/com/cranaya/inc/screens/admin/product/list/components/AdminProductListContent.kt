package com.cranaya.inc.screens.admin.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cranaya.domain.product.model.Product

@Composable
fun AdminProductListContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    products: List<Product>
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(items = products) {
            AdminProductListItem(navController = navController, product = it)
        }
    }
}