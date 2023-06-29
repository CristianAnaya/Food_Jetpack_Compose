package com.cranaya.inc.screens.client.payments.status.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.MainActivity
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.screens.auth.login.LoginScreen
import com.cranaya.inc.screens.client.payments.status.ClientPaymentsStatusViewModel
import com.cranaya.inc.ui.theme.RedworkTheme

@Composable
fun ClientPaymentsStatusContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: ClientPaymentsStatusViewModel = hiltViewModel()
) {

    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.checked),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Tu orden fue procesada exitosamente /nUtilizando la tarjeta" +
                    " ${viewModel.paymentResponse.paymentMethod} **** ${viewModel.paymentResponse.card.lastFourDigits}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = "Mira el estado de tu compra en la seccion de pedidos",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Finalizar compra",
            onClick = {
                navController.navigate(route = Graph.CLIENT) {
                    popUpTo(Graph.SHOPPING_BAG) { inclusive = true }
                }
            }
        )
    }

}