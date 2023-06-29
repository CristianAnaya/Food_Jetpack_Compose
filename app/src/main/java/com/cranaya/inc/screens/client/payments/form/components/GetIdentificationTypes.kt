package com.cranaya.inc.screens.client.payments.form.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.client.payments.form.ClientPaymentFormViewModel

@Composable
fun GetIdentificationTypes(
    paddingValues: PaddingValues,
    viewModel: ClientPaymentFormViewModel = hiltViewModel()
) {

    when(val response = viewModel.identificationTypeResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientPaymentsFormContent(
                paddingValues = paddingValues,
                identificationTypes = response.data.map { identificationType -> identificationType.id }
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