package com.cranaya.inc.screens.client.order.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.screens.client.order.list.components.GetOrders

@Composable
fun ClientOrderListScreen(
    navController: NavHostController,
    viewModel: ClientOrderListViewModel = hiltViewModel()
) {
    
    viewModel.getSessionData()

    Scaffold {
        GetOrders(paddingValues = it, navController = navController)
    }
    
}