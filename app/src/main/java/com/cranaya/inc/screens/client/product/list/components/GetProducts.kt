package com.cranaya.inc.screens.client.product.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.admin.categotry.list.AdminCategoryListViewModel
import com.cranaya.inc.screens.admin.product.list.AdminProductListViewModel
import com.cranaya.inc.screens.client.product.list.ClientProductListViewModel

@Composable
fun GetProducts(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ClientProductListViewModel = hiltViewModel()
) {

    when(val response = viewModel.productsResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientProductListContent(navController = navController, paddingValues = paddingValues, products = response.data)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null)
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
        }
    }

}