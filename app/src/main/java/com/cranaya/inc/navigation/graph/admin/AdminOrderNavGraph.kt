package com.cranaya.inc.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.admin.AdminOrderScreen
import com.cranaya.inc.screens.admin.order.detail.AdminOrderDetailScreen


fun NavGraphBuilder.AdminOrderNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_ORDER,
        startDestination = AdminOrderScreen.OrderDetail.route
    ) {
        composable(
            route = AdminOrderScreen.OrderDetail.route,
            arguments = listOf(navArgument("order") {
                type = NavType.StringType
            })
        ) {
            AdminOrderDetailScreen(navController = navController)
        }
    }
}