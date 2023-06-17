package com.cranaya.inc.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.navigation.graph.auth.AuthNavGraph
import com.cranaya.inc.navigation.graph.roles.RolesNavGraph

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
    }
}