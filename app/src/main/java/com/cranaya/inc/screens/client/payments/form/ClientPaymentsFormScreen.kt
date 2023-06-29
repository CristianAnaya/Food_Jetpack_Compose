package com.cranaya.inc.screens.client.payments.form

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.payments.form.components.ClientPaymentsFormContent
import com.cranaya.inc.screens.client.payments.form.components.GetIdentificationTypes

@Composable
fun ClientPaymentsFormScreen(
    navController: NavHostController,
    viewModel: ClientPaymentFormViewModel = hiltViewModel()
) {
    viewModel.getIdentificationTypes()
    //viewModel.getInstallments(512069, 100000.0)

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Formulario de pago",
                upAvailable = true,
                navController = navController
            )
        }
    ) {
        GetIdentificationTypes(paddingValues = it, navController = navController)
    }

}