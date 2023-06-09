package com.cranaya.inc.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTextField
import com.cranaya.inc.ui.theme.Blue700

@Composable
fun LoginContent(paddingValues: PaddingValues) {
    Box(modifier = Modifier) {
        Image(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "background image",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f) }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp), // it has all width of the screen
            horizontalAlignment = Alignment.CenterHorizontally // all elements will be centered
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo"
            )

            Text(
                modifier = Modifier.padding(top = 7.dp),
                text = "ECOMMERCE APP",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                ),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(top = 30.dp, end = 30.dp, start = 30.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Sign in",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Email",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Password",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    
                    Spacer(modifier = Modifier.height(10.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "Sign in",
                        onClick = {  }
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 17.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "You don't have Account?")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Sign up",
                            color = Blue700
                        )
                    }
                }
            }
        }
    }
}