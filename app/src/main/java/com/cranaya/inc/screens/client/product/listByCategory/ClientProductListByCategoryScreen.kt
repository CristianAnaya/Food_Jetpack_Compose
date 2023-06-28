package com.cranaya.inc.screens.client.product.listByCategory

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.domain.category.model.Category
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.product.listByCategory.components.GetProductsByCategory

@Composable
fun ClientProductListByCategoryScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        GetProductsByCategory(navController = navController, paddingValues = it)
    }

}