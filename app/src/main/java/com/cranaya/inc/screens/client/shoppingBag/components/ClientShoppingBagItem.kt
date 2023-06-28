package com.cranaya.inc.screens.client.shoppingBag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.inc.R
import com.cranaya.inc.screens.client.shoppingBag.ClientShoppingBagViewModel
import com.cranaya.inc.ui.theme.Gray700

@Composable
fun ClientShoppingBagItem(
    shoppingBag: ShoppingBag,
    viewModel: ClientShoppingBagViewModel = hiltViewModel()
) {

    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = shoppingBag.image1,
            contentDescription = "",
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column() {
            Text(
                modifier = Modifier.width(150.dp),
                text = shoppingBag.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(5.dp))
            
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(35.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Gray700
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable { viewModel.subtractItem(shoppingBag) },
                        text = "-",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = shoppingBag.quantity.toString(),
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable { viewModel.addItem(shoppingBag) },
                        text = "+",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = (shoppingBag.price * shoppingBag.quantity).toString())

            Spacer(modifier = Modifier.height(7.dp))
            
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { viewModel.deleteItem(shoppingBag.id) },
                painter = painterResource(id = R.drawable.trash),
                contentDescription = ""
            )
        }
        
    }

}