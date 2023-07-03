package com.cranaya.inc.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.graph.profile.ProfileNavGraph
import com.cranaya.inc.navigation.screen.client.ClientScreen
import com.cranaya.inc.screens.client.category.list.ClientCategoryListScreen
import com.cranaya.inc.screens.client.order.list.ClientOrderListScreen
import com.cranaya.inc.screens.client.product.list.ClientProductListScreen
import com.cranaya.inc.screens.profile.info.ProfileScreen

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
            ClientProductListScreen(navController = navController)
        }

        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen(navController = navController)
        }

        composable(route = ClientScreen.OrderList.route) {
            ClientOrderListScreen(navController = navController)
        }

        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        ProfileNavGraph(navController = navController)
        ClientCategoryNavGraph(navController = navController)
        ClientProductNavGraph(navController = navController)
        ShoppingBagNavGraph(navController = navController)
        ClientOrderNavGraph(navController = navController)
    }

}