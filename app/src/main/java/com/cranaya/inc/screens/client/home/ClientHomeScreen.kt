package com.cranaya.inc.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.navigation.graph.client.ClientNavGraph
import com.cranaya.inc.screens.client.home.componentes.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) {
        ClientNavGraph(navController = navController)
    }

}