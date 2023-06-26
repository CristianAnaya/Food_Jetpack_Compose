package com.cranaya.inc.screens.admin.product.update.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cranaya.inc.R
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTextField
import com.cranaya.inc.components.DialogCapturePicture
import com.cranaya.inc.screens.admin.product.update.AdminProductUpdateViewModel

@Composable
fun AdminProductUpdateContent(
    paddingValues: PaddingValues,
    viewModel: AdminProductUpdateViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val stateDialog = remember { mutableStateOf(false) }
    val stateDialogImageNumber = remember { mutableStateOf(1) }

    viewModel.resultingActivityHandler.handle()

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { viewModel.takePhoto(stateDialogImageNumber.value) },
        pickImage = { viewModel.pickImage(stateDialogImageNumber.value) }
    )

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (state.image1.isNotBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialogImageNumber.value = 1
                            stateDialog.value = true
                        },
                    model = state.image1,
                    contentDescription = "",
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 1
                        },
                    painter = painterResource(id = R.drawable.image_add),
                    contentDescription = ""
                )
            }
            
            Spacer(modifier = Modifier.width(15.dp))

            if (state.image2.isNotBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 2
                        },
                    model = state.image2,
                    contentDescription = "",
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialogImageNumber.value = 2
                            stateDialog.value = true
                        },
                    painter = painterResource(id = R.drawable.image_add),
                    contentDescription = ""
                )
            }
        }


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

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { viewModel.onNameInput(it) },
                    label = "Nombre del producto",
                    icon = Icons.Default.List
                )

                Spacer(modifier = Modifier.height(10.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = { viewModel.onDescriptionInput(it) },
                    label = "Descripción",
                    icon = Icons.Default.Info
                )

                Spacer(modifier = Modifier.height(10.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.price.toString(),
                    onValueChange = { viewModel.onPriceInput(it) },
                    label = "Precio",
                    icon = Icons.Default.Info,
                    keyboardType = KeyboardType.Number
                )


                Spacer(modifier = Modifier.weight(1f))

                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Actualizar producto",
                    onClick = { viewModel.updateProduct() }
                )
            }
        }
    }
}