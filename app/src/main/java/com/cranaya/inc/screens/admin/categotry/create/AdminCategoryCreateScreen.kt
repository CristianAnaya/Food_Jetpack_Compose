package com.cranaya.inc.screens.admin.categotry.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.admin.categotry.create.component.AdminCategoryCreateContent
import com.cranaya.inc.screens.admin.categotry.create.component.CreateCategory
import com.cranaya.inc.ui.theme.Gray200

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {

    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Nueva Categoria",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200
    ){
        AdminCategoryCreateContent(paddingValues = it)
    }

    CreateCategory()
}