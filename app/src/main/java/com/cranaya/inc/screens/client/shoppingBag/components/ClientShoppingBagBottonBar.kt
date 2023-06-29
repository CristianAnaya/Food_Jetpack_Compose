package com.cranaya.inc.screens.client.shoppingBag.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.shoppingBag.ClientShoppingBagViewModel
import com.cranaya.inc.ui.theme.Gray100

@Composable
fun ClientShoppingBagBottomBar(navController: NavHostController, viewModel: ClientShoppingBagViewModel = hiltViewModel()) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray100),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )

            Text(
                text = viewModel.total.toString() + "$",
                fontSize = 17.sp
            )
        }

        DefaultButton(
            modifier = Modifier
                .width(150.dp)
                .padding(vertical = 15.dp),
            text = "Confirmar orden",
            onClick = { navController.navigate(route = ShoppingBagScreen.AddressList.route) }
        )
    }
}