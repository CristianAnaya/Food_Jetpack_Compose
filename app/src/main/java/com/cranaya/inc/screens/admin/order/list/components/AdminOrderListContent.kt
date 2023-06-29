package com.cranaya.inc.screens.admin.order.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AdminOrderListContent(
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    Text(
        modifier = Modifier.padding(paddingValues),
        text = "AdminOrderListScreen"
    )

}