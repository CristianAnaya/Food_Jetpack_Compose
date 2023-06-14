package com.cranaya.inc.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.ClientScreen
import com.cranaya.inc.screens.client.category.list.ClientCategoryListScreen
import com.cranaya.inc.screens.client.product.list.ClientProductListScreen
import com.cranaya.inc.screens.client.product.list.components.ClientProductListContent
import com.cranaya.inc.screens.profile.ProfileScreen

@Composable
fun ClientNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {

        composable(route = ClientScreen.ProductList.route) {
            ClientProductListScreen()
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen()
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen()
        }
    }

}