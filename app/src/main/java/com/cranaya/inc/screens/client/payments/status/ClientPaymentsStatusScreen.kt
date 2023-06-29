package com.cranaya.inc.screens.client.payments.status

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.client.payments.status.components.ClientPaymentsStatusContent

@Composable
fun ClientPaymentsStatusScreen(navController: NavHostController) {
    
    Scaffold() {
        ClientPaymentsStatusContent(paddingValues = it, navController = navController)
    }
    
}