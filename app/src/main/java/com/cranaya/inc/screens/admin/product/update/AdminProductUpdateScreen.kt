package com.cranaya.inc.screens.admin.product.update

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.admin.product.create.components.AdminProductCreateContent
import com.cranaya.inc.screens.admin.product.create.components.CreateProduct
import com.cranaya.inc.screens.admin.product.update.components.AdminProductUpdateContent
import com.cranaya.inc.screens.admin.product.update.components.UpdateProduct
import com.cranaya.inc.ui.theme.Gray200

@Composable
fun AdminProductUpdateScreen(
    navController: NavHostController,
    productParam: String
) {
    
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar producto",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200
    ) {
        AdminProductUpdateContent(paddingValues = it)
    }

    UpdateProduct()
}