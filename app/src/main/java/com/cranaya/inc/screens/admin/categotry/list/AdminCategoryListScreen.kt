package com.cranaya.inc.screens.admin.categotry.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.screens.admin.categotry.list.components.AdminCategoryListContent
import com.cranaya.inc.screens.admin.categotry.list.components.DeleteCategory
import com.cranaya.inc.screens.admin.categotry.list.components.GetCategories
import com.cranaya.inc.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun AdminCategoryListScreen(navController: NavHostController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add category"
                )
            }
        }
    ) {
        GetCategories(navController = navController, paddingValues = it)
    }

    DeleteCategory()
}