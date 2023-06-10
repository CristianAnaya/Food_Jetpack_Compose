package com.cranaya.inc.screens.auth.register.components

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTextField
import com.cranaya.inc.screens.auth.register.RegisterScreen
import com.cranaya.inc.ui.theme.RedworkTheme

@Composable
fun RegisterContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize() // width and height of the screen
    ) {
        BackgroundImage()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HeaderBanner()

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    contentColor = Color.White.copy(alpha = 0.08f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Register",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Name",
                        icon = Icons.Default.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Lastname",
                        icon = Icons.Outlined.Person
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
                        label = "Phone",
                        icon = Icons.Outlined.Phone,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Password",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Confirm Password",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "Confirm",
                        onClick = {  }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterContentPreview() {
    RedworkTheme {
    }
}