package com.cranaya.inc.screens.client.category.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.cranaya.domain.category.model.Category
import com.cranaya.inc.navigation.screen.client.ClientCategoryScreen

@Composable
fun ClientCategoryListItem(navController: NavHostController, category: Category) {

    Card(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .clickable {
                navController.navigate(route = ClientCategoryScreen.ProductList.passCategory(category.toJson()))
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = category.image,
                contentDescription = "category image",
//                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = category.name,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                text = category.description,
                fontSize = 14.sp,
                color = Color.Gray
            )

        }
    }
}