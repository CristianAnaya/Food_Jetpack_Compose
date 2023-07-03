package com.cranaya.inc.screens.client.order.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cranaya.domain.order.model.Order

@Composable
fun ClientOrderListContent(
    paddingValues: PaddingValues,
    orders: List<Order>,
    navController: NavHostController
) {

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(bottom = 55.dp)
            .fillMaxSize()
    ) {
        items(
            items = orders
        ) {
            ClientOrderListItem(order = it, navController)
        }
    }

}