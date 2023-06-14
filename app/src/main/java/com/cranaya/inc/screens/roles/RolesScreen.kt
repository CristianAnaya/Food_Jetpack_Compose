package com.cranaya.inc.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {
    
    Scaffold(
        topBar = { DefaultTopBar(title = "Selecciona un rol") }
    ) {
        RolesContent(it, navController)
    }
}