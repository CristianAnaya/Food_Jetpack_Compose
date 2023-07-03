package com.cranaya.inc.screens.client.order.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.order.detail.components.ClientOrderDetailContent

@Composable
fun ClientOrderDetailScreen(
    navController: NavHostController,
    viewModel: ClientOrderDetailViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detalle de la orden",
                navController = navController,
                upAvailable = true
            )
        }
    ) {
        ClientOrderDetailContent(
            paddingValues = it,
            viewModel.order
        )
    }

}