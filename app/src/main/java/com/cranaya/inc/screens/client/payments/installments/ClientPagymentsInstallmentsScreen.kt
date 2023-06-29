package com.cranaya.inc.screens.client.payments.installments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.payments.installments.components.CreateCardToken
import com.cranaya.inc.screens.client.payments.installments.components.CreatePayment
import com.cranaya.inc.screens.client.payments.installments.components.GetInstallments

@Composable
fun ClientPaymentsInstallmentsScreen(
    navController: NavHostController,
    viewModel: ClientPaymentsInstallmentsViewModel = hiltViewModel()
) {

    viewModel.getInstallments(
        viewModel.cardTokenBody.cardNumber.substring(0, 6).toInt(),
        10000.0
    )

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Numero de cuotas"
            )
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Confirmar transaccion",
                onClick = { viewModel.createCardToken() }
            )
        }
    ) {
            GetInstallments(paddingValues = it)
    }

    CreateCardToken()
    CreatePayment(navController = navController)
}
