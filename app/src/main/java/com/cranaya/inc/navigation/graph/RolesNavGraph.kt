package com.cranaya.inc.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.AuthScreen
import com.cranaya.inc.navigation.screen.RolesScreen
import com.cranaya.inc.screens.client.home.ClientHomeScreen
import com.cranaya.inc.screens.roles.RolesScreen


fun NavGraphBuilder.RolesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {
        composable(route = RolesScreen.Roles.route) {
            RolesScreen(navController = navController)
        }

        composable(route = Graph.CLIENT) {
            ClientHomeScreen()
        }

    }
}