package com.cranaya.inc.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.admin.AdminOrderScreen
import com.cranaya.inc.navigation.screen.client.ClientOrderScreen
import com.cranaya.inc.screens.admin.order.detail.AdminOrderDetailScreen
import com.cranaya.inc.screens.client.order.detail.ClientOrderDetailScreen


fun NavGraphBuilder.ClientOrderNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_ORDER,
        startDestination = ClientOrderScreen.OrderDetail.route
    ) {
        composable(
            route = ClientOrderScreen.OrderDetail.route,
            arguments = listOf(navArgument("order") {
                type = NavType.StringType
            })
        ) {
            ClientOrderDetailScreen(navController = navController)
        }
    }
}