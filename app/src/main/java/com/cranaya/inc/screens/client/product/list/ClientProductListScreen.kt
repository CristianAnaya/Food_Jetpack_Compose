package com.cranaya.inc.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                navController = navController,
                enableActions = true
            )
        }
    ) {
        GetProducts(navController = navController, paddingValues = it)
    }

}