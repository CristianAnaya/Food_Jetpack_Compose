package com.cranaya.inc.screens.admin.order.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.admin.order.detail.components.AdminOrderDetailContent
import com.cranaya.inc.screens.admin.order.detail.components.UpdateStatusOrder

@Composable
fun AdminOrderDetailScreen(
    navController: NavHostController,
    viewModel: AdminOrderDetailViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detaille de la orden",
                navController = navController,
                upAvailable = true
            )
        }
    ) {
        AdminOrderDetailContent(
            paddingValues = it,
            viewModel.order
        )
    }
    UpdateStatusOrder()

}