package com.cranaya.inc.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultSearchView
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(
    navController: NavHostController,
    viewModel: ClientProductListViewModel = hiltViewModel()
) {

    viewModel.getProducts()

    Scaffold(
        topBar = {
            DefaultSearchView(
                value = viewModel.search,
                onValueChange = {
                    viewModel.onSearchInput(it)
                },
                navController = navController,
                onClick = {
                    if (viewModel.search.isNotBlank()) viewModel.getProductsByName(viewModel.search)
                }
            )
        }
    ) {
        GetProducts(navController = navController, paddingValues = it)
    }

}