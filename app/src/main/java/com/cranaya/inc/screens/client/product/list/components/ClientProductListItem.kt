package com.cranaya.inc.screens.client.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.cranaya.domain.product.model.Product
import com.cranaya.inc.R
import com.cranaya.inc.navigation.screen.admin.AdminCategoryScreen
import com.cranaya.inc.navigation.screen.client.ClientCategoryScreen
import com.cranaya.inc.screens.admin.product.list.AdminProductListViewModel
import com.cranaya.inc.screens.client.product.list.ClientProductListViewModel

@Composable
fun ClientProductListItem(
    navController: NavHostController,
    product: Product,
    viewModel: ClientProductListViewModel = hiltViewModel()
) {

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
            .clickable { navController.navigate(route = ClientCategoryScreen.ProductDetail.passProduct(product.toJson())) }
    ) {
        Row() {

            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    color = Color.Black,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = product.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Text(
                    text = product.price.toString(),
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.image1,
                contentDescription = "category image"
            )

            Spacer(modifier = Modifier.width(10.dp))

        }

        Spacer(modifier = Modifier.height(10.dp))
        
        Divider(
            modifier = Modifier.padding(end = 20.dp),
            color = Color.LightGray
        )
    }
}