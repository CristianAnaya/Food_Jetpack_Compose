package com.cranaya.inc.screens.admin.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AdminHomeScreen(navController: NavHostController) {

    Scaffold {
        Text(
            modifier = Modifier.padding(it),
            text = "Admin HomeScreen"
        )
    }
}