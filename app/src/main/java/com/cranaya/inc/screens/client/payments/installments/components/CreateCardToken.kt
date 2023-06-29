package com.cranaya.inc.screens.client.payments.installments.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.client.payments.form.ClientPaymentFormViewModel
import com.cranaya.inc.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun CreateCardToken(
    viewModel: ClientPaymentsInstallmentsViewModel = hiltViewModel()
) {

    when(val response = viewModel.cardTokenResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            viewModel.createPayment(response.data.id)
            Toast.makeText(LocalContext.current,"El card token se ha creado", Toast.LENGTH_SHORT).show()
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