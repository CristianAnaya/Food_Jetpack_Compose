package com.cranaya.inc.screens.client.order.list.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cranaya.domain.order.model.Order
import com.cranaya.inc.navigation.screen.admin.AdminOrderScreen
import com.cranaya.inc.navigation.screen.client.ClientOrderScreen
import com.cranaya.inc.ui.theme.Gray100

@Composable
fun ClientOrderListItem(order: Order, navController: NavHostController) {

    Log.d("TAG", "AdminOrderListItem: ${order.toJson()}")
    Column(
        modifier = Modifier
            .padding(20.dp)
            .clickable {
                navController.navigate(
                    route = ClientOrderScreen.OrderDetail.passOrder(order.toJson())
                )
            }
    ) {
        Text(
            text = "Orden #${order.id}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Pedido ${order.createdAt}",
            fontSize = 15.sp
        )

        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Cliente ${order.client?.name} ${order.client?.lastname}",
            fontSize = 15.sp
        )

        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Entregar en ",
            fontSize = 15.sp
        )

        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Estado ${order.status}",
            fontSize = 15.sp
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            color = Gray100
        )
    }

}