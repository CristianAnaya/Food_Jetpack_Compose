package com.cranaya.inc.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.screen.auth.AuthScreen
import com.cranaya.inc.screens.auth.register.RegisterScreen
import com.cranaya.inc.screens.auth.login.LoginScreen


fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(
            route = AuthScreen.Login.route
        ) {
            LoginScreen(navController = navController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController = navController)
        }
    }

}