package com.cranaya.inc.screens.client.order.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.client.order.list.ClientOrderListViewModel

@Composable
fun GetOrders(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ClientOrderListViewModel = hiltViewModel()
) {

    when(val response = viewModel.orderResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientOrderListContent(
                paddingValues = paddingValues,
                orders = response.data,
                navController = navController
            )
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