package com.cranaya.inc.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.admin.AdminCategoryScreen
import com.cranaya.inc.navigation.screen.roles.RolesScreen
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateScreen
import com.cranaya.inc.screens.admin.categotry.update.AdminCategoryUpdateScreen
import com.cranaya.inc.screens.admin.home.AdminHomeScreen
import com.cranaya.inc.screens.client.home.ClientHomeScreen
import com.cranaya.inc.screens.roles.RolesScreen


fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ) {
        composable(route = AdminCategoryScreen.CategoryCreate.route) {
            AdminCategoryCreateScreen(navController = navController)
        }

        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let { category ->
                AdminCategoryUpdateScreen(navController = navController, categoryParam = category)
            }

        }
    }
}