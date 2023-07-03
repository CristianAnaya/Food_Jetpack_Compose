package com.cranaya.inc.screens.admin.order.detail.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.admin.order.detail.AdminOrderDetailViewModel

@Composable
fun UpdateStatusOrder(
    viewModel: AdminOrderDetailViewModel = hiltViewModel()
) {

    when(val response = viewModel.orderStatusResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "La orden se ha actualizado correctamente", Toast.LENGTH_SHORT).show()
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