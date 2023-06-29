package com.cranaya.inc.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.graph.profile.ProfileNavGraph
import com.cranaya.inc.navigation.screen.admin.AdminScreen
import com.cranaya.inc.screens.admin.categotry.list.AdminCategoryListScreen
import com.cranaya.inc.screens.admin.order.list.AdminOrderListScreen
import com.cranaya.inc.screens.admin.product.list.AdminProductListScreen
import com.cranaya.inc.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.CategoryList.route
    ) {

//        composable(route = AdminScreen.ProductList.route) {
//            AdminProductListScreen()
//        }

        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen(navController = navController)
        }

        composable(route = AdminScreen.OrderList.route) {
            AdminOrderListScreen(navController = navController)
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        ProfileNavGraph(navController = navController)
        AdminCategoryNavGraph(navController = navController)
    }
}