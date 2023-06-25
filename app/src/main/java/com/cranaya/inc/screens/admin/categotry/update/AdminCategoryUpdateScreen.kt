package com.cranaya.inc.screens.admin.categotry.update

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.admin.categotry.create.component.AdminCategoryCreateContent
import com.cranaya.inc.screens.admin.categotry.create.component.CreateCategory
import com.cranaya.inc.screens.admin.categotry.update.component.AdminCategoryUpdateContent
import com.cranaya.inc.screens.admin.categotry.update.component.UpdateCategory
import com.cranaya.inc.ui.theme.Gray200

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String) {

    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Actualizar categoria",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200
    ){
        AdminCategoryUpdateContent(paddingValues = it)
    }

    UpdateCategory()
}