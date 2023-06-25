package com.cranaya.inc.navigation.screen.admin


sealed class AdminCategoryScreen(val route: String) {
    object CategoryCreate: AdminCategoryScreen("admin/category/create")
    object CategoryUpdate: AdminCategoryScreen("admin/category/update/{category}") {
        fun passCategory(category: String) = "admin/category/update/$category"
    }
}
