package com.cranaya.inc.screens.client.address.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.address.list.components.ClientAddressListContent
import com.cranaya.inc.screens.client.address.list.components.GetAddress

@Composable
fun ClientAddressListScreen(
    navController: NavHostController,
    viewModel: ClientAddressListViewModel = hiltViewModel()
) {

    viewModel.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mis direcciones",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = { navController.navigate(route = ShoppingBagScreen.AddressCreate.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add category"
                )
            }
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.padding(20.dp),
                text = "Continuar",
                onClick = { navController.navigate(route = ShoppingBagScreen.PaymentsForm.route) }
            )
        }
    ) {
        GetAddress(paddingValues = it)
    }
    
}