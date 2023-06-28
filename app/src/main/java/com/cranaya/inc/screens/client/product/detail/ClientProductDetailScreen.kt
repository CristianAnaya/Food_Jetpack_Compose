package com.cranaya.inc.screens.client.product.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.client.product.detail.components.ClientProductDetailContent

@Composable
fun ClientProductDetailScreen(navController: NavHostController, productParam: String) {
    
    Scaffold {
        ClientProductDetailContent(paddingValues = it)
    }
    
}