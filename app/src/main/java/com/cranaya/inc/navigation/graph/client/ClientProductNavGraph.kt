package com.cranaya.inc.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.admin.AdminCategoryScreen
import com.cranaya.inc.navigation.screen.client.ClientCategoryScreen
import com.cranaya.inc.navigation.screen.client.ClientProductScreen
import com.cranaya.inc.navigation.screen.roles.RolesScreen
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateScreen
import com.cranaya.inc.screens.admin.categotry.update.AdminCategoryUpdateScreen
import com.cranaya.inc.screens.admin.home.AdminHomeScreen
import com.cranaya.inc.screens.admin.product.create.AdminProductCreateScreen
import com.cranaya.inc.screens.admin.product.list.AdminProductListScreen
import com.cranaya.inc.screens.admin.product.update.AdminProductUpdateScreen
import com.cranaya.inc.screens.client.home.ClientHomeScreen
import com.cranaya.inc.screens.client.product.detail.ClientProductDetailScreen
import com.cranaya.inc.screens.client.product.list.ClientProductListScreen
import com.cranaya.inc.screens.client.product.listByCategory.ClientProductListByCategoryScreen
import com.cranaya.inc.screens.roles.RolesScreen


fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ) {
        composable(
            route = ClientProductScreen.ProductDetail.route,
            arguments = listOf(navArgument("product"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let { product ->
                ClientProductDetailScreen(navController = navController, productParam = product)
            }
        }
    }
}