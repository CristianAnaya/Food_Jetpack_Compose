package com.cranaya.inc.screens.admin.product.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.admin.product.create.components.AdminProductCreateContent

@Composable
fun AdminProductCreateScreen(navController: NavHostController, categoryParam: String) {
    
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Crear productos",
                upAvailable = true,
                navController = navController
            )
        },
    ) {
        AdminProductCreateContent(paddingValues = it)
    }
}