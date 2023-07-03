package com.cranaya.inc.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen

@Composable
fun DefaultSearchView(
    value: String,
    onValueChange: (value: String) -> Unit,
    navController: NavHostController,
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = {
                    onValueChange(it)
                },
                label = {
                    Text(
                        text = "Buscar producto",
                        fontSize = 15.sp
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { onClick() }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle.Default.copy(fontSize = 15.sp)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.White
        ),
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(route = ShoppingBagScreen.ShoppingBag.route)
                }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        }
    )
}