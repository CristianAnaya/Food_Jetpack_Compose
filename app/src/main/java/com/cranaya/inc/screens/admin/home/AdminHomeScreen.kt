package com.cranaya.inc.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.navigation.graph.admin.AdminNavGraph
import com.cranaya.inc.screens.admin.home.componentes.AdminBottomBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController) }
    ) {
        AdminNavGraph(navController = navController)

    }
}