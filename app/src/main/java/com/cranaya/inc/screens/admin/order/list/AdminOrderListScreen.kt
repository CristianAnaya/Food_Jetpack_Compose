package com.cranaya.inc.screens.admin.order.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.admin.order.list.components.AdminOrderListContent

@Composable
fun AdminOrderListScreen(
    navController: NavHostController,
    viewModel: AdminOrderListViewModel = hiltViewModel()
) {
    
    viewModel.getOrders()
    viewModel.getOrdersByClient("8")
    viewModel.updateStatus("2")

    Scaffold {
        AdminOrderListContent(paddingValues = it, navController)
    }
    
}