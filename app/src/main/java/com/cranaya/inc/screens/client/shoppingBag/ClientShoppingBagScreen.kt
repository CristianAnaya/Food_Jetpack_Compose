package com.cranaya.inc.screens.client.shoppingBag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
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
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.shoppingBag.components.ClientShoppingBagBottomBar
import com.cranaya.inc.screens.client.shoppingBag.components.ClientShoppingBagContent
import com.cranaya.inc.ui.theme.Gray100

@Composable
fun ClientShoppingBagScreen(navController: NavHostController, viewModel: ClientShoppingBagViewModel = hiltViewModel()) {

    viewModel.getShoppingBag()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mi orden",
                upAvailable = true,
                navController = navController
            )
        },
        bottomBar = {
            ClientShoppingBagBottomBar(navController = navController)
        }
    ) {
        ClientShoppingBagContent(paddingValues = it, viewModel.shoppingBags)
    }
}