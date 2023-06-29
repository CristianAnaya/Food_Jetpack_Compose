package com.cranaya.inc.screens.client.address.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTextField
import com.cranaya.inc.screens.client.address.create.ClientAddressCreateViewModel

@Composable
fun ClientAddressCreateContent(paddingValues: PaddingValues, viewModel: ClientAddressCreateViewModel = hiltViewModel()) {

    val state = viewModel.state

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.map),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            backgroundColor = Color.White
        ) {

            Column(modifier = Modifier.padding(20.dp)) {

                Text(
                    modifier = Modifier.padding(bottom = 20.dp),
                    text = "Dirección",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.address,
                    onValueChange = { viewModel.onAddressInput(it) },
                    label = "Dirección",
                    icon = Icons.Default.LocationOn
                )

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.neighborhood,
                    onValueChange = { viewModel.onNeighborhoodInput(it) },
                    label = "Barrio",
                    icon = Icons.Default.Info
                )

                Spacer(modifier = Modifier.weight(1f))

                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear dirección",
                    onClick = { viewModel.createAddress() }
                )
            }
        }
    }

}