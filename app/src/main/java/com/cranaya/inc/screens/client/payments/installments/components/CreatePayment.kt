package com.cranaya.inc.screens.client.payments.installments.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.payments.form.ClientPaymentFormViewModel
import com.cranaya.inc.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun CreatePayment(
    navController: NavHostController,
    viewModel: ClientPaymentsInstallmentsViewModel = hiltViewModel()
) {

    when(val response = viewModel.paymentResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(route = ShoppingBagScreen.PaymentsStatus.passPaymentResponse(response.data.toJson())) {
                    popUpTo(ShoppingBagScreen.PaymentsInstallments.route) { inclusive = true }
                }
            }
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