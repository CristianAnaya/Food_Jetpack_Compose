package com.cranaya.inc.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.address.list.ClientAddressListScreen
import com.cranaya.inc.screens.client.payments.form.ClientPaymentsFormScreen
import com.cranaya.inc.screens.client.payments.installments.ClientPaymentsInstallmentsScreen
import com.cranaya.inc.screens.client.payments.status.ClientPaymentsStatusScreen
import com.cranaya.inc.screens.client.shoppingBag.ClientShoppingBagScreen


fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ) {
        composable(
            route = ShoppingBagScreen.ShoppingBag.route,
        ) {
            ClientShoppingBagScreen(navController = navController)
        }

        composable(
            route = ShoppingBagScreen.AddressList.route,
        ) {
            ClientAddressListScreen(navController = navController)
        }

        composable(
            route = ShoppingBagScreen.PaymentsForm.route,
        ) {
            ClientPaymentsFormScreen(navController = navController)
        }

        composable(
            route = ShoppingBagScreen.PaymentsInstallments.route,
            arguments = listOf(navArgument("payment_form"){
                type = NavType.StringType
            })
        ) {
            ClientPaymentsInstallmentsScreen(navController = navController)

        }

        composable(
            route = ShoppingBagScreen.PaymentsStatus.route,
            arguments = listOf(navArgument("payment"){
                type = NavType.StringType
            })
        ) {
            ClientPaymentsStatusScreen(navController = navController)

        }
    }
}