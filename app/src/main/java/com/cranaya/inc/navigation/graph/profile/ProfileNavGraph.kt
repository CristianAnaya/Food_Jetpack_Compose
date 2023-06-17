package com.cranaya.inc.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.profile.ProfileScreen
import com.cranaya.inc.navigation.screen.roles.RolesScreen
import com.cranaya.inc.screens.admin.home.AdminHomeScreen
import com.cranaya.inc.screens.client.home.ClientHomeScreen
import com.cranaya.inc.screens.profile.update.ProfileUpdateScreen
import com.cranaya.inc.screens.roles.RolesScreen


fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let { data ->
                ProfileUpdateScreen(navController = navController, data)
            }
        }

    }
}