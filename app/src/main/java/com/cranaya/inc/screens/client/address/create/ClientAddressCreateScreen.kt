package com.cranaya.inc.screens.client.address.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.client.address.create.components.ClientAddressCreateContent
import com.cranaya.inc.screens.client.address.create.components.CreateAddress
import com.cranaya.inc.screens.client.address.list.components.ClientAddressListContent
import com.cranaya.inc.ui.theme.Gray100

@Composable
fun ClientAddressCreateScreen(navController: NavHostController, viewModel: ClientAddressCreateViewModel = hiltViewModel()) {

    viewModel.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva dirección",
                navController = navController,
                upAvailable = true
            )
        },
        containerColor = Gray100
    ) {
        ClientAddressCreateContent(paddingValues = it)
    }

    CreateAddress()
}