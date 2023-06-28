package com.cranaya.inc.screens.client.product.listByCategory.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.client.product.listByCategory.ClientProductListByCategoryViewModel

@Composable
fun GetProductsByCategory(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ClientProductListByCategoryViewModel = hiltViewModel()
) {

    when(val response = viewModel.productsResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientProductListByCategoryContent(navController = navController, paddingValues = paddingValues, products = response.data)
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