package com.cranaya.inc.screens.admin.order.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.admin.order.list.components.GetOrders

@Composable
fun AdminOrderListScreen(
    navController: NavHostController,
    viewModel: AdminOrderListViewModel = hiltViewModel()
) {
    
    viewModel.getOrders()

    Scaffold {
        GetOrders(paddingValues = it, navController = navController)
    }
    
}