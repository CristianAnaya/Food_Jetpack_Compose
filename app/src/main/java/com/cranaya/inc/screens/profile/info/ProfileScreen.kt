package com.cranaya.inc.screens.profile.info

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.profile.info.components.ProfileContent

@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold() {
        ProfileContent(paddingValues = it, navController = navController)
    }

}