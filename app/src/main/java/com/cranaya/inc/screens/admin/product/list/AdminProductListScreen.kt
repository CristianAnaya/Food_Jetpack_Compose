package com.cranaya.inc.screens.admin.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cranaya.domain.category.model.Category
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.admin.AdminCategoryScreen
import com.cranaya.inc.screens.admin.product.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                upAvailable = true,
                navController = navController
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = { navController.navigate(route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse)) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add category"
                )
            }
        }
    ) {
        AdminProductListContent(paddingValues = it)
    }

}