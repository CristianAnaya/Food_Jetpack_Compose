package com.cranaya.inc.screens.admin.order.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.order.model.Order
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.screens.admin.order.detail.AdminOrderDetailViewModel
import com.cranaya.inc.ui.theme.Gray100

@Composable
fun AdminOrderDetailContent(
    paddingValues: PaddingValues,
    order: Order,
    viewModel: AdminOrderDetailViewModel = hiltViewModel()
) {

    Column() {
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .background(color = Gray100)
                .weight(1f)
        ) {
            items(
                items = order.orderHasProducts ?: listOf()
            ) {
                AdminOrderDetailItem(
                    orderHasProducts = it
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Fecha del pedido",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = order.createdAt ?: ""
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.reloj),
                        contentDescription = ""
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Client y telefono",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.client?.name} ${order.client?.lastname} - ${order.client?.lastname}"
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Dirección de entrega",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.address?.neighborhood}"
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total: $${viewModel.totalToPay}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    DefaultButton(
                        modifier = Modifier,
                        text = "DESPACHAR",
                        onClick = { viewModel.updateStatus(order.id ?: "") }
                    )
                }
            }
        }
    }

}