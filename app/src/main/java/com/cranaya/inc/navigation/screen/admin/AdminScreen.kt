package com.cranaya.inc.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object CategoryList: AdminScreen(
        route = "admincategory/list",
        title = "Categorias",
        icon = Icons.Default.Check
    )

    object ProductList: AdminScreen(
        route = "admin/product/list",
        title = "Productos",
        icon = Icons.Default.List
    )

    object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
