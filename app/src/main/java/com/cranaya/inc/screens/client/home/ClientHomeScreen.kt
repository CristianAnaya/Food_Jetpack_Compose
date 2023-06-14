package com.cranaya.inc.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.navigation.graph.ClientNavGraph
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