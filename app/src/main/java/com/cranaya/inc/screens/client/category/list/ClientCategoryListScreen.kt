package com.cranaya.inc.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.client.category.list.components.GetCategories

@Composable
fun ClientCategoryListScreen(navController: NavHostController) {

    Scaffold() {
        GetCategories(paddingValues =  it, navController = navController)
    }

}