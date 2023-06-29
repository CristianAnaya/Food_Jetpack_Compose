package com.cranaya.inc.screens.client.payments.form.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DefaultTextField
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import com.cranaya.inc.screens.client.payments.form.ClientPaymentFormViewModel
import com.cranaya.inc.screens.client.payments.form.mapper.toCardTokenBody

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientPaymentsFormContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    identificationTypes: List<String>,
    viewModel: ClientPaymentFormViewModel = hiltViewModel(),
) {

    val state = viewModel.state
    var selectedItem by remember { mutableStateOf(identificationTypes[0]) }
    viewModel.onIdentificationTypeInput(selectedItem)
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)

    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { viewModel.onCardNumberInput(it) } ,
            label = "Numero de la tarjeta",
            icon = Icons.Default.Settings
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationYear,
                onValueChange = { viewModel.onExpirationYearInput(it) },
                label = "Año de expiración YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )

            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationMonth,
                onValueChange = { viewModel.onExpirationMonthInput(it) },
                label = "Mes de expiración MM",
                icon = Icons.Default.Settings,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
        }

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { viewModel.onNameInput(it) } ,
            label = "Nombre del titular",
            icon = Icons.Default.Person,
        )

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { viewModel.onSecurityCodeInput(it) } ,
            label = "Codigod de seguridad",
            icon = Icons.Default.Lock,
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )

            ExposedDropdownMenu(
                modifier = Modifier.background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                identificationTypes.forEachIndexed { index, identification ->
                    androidx.compose.material.DropdownMenuItem(
                        onClick = {
                            selectedItem = identification
                            viewModel.onIdentificationTypeInput(selectedItem)
                            expanded = false
                        }
                    ) {
                        Text(text = identification)
                    }
                }
            }
        }

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { viewModel.onIdentificationNumberInput(it) } ,
            label = "Numero de identificacion",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )

        Spacer(modifier = Modifier.weight(1f))

        DefaultButton(modifier = Modifier.fillMaxWidth(),
            text = "Continuar",
            onClick = {
                navController.navigate(route = ShoppingBagScreen.PaymentsInstallments.passPaymentForm(state.toCardTokenBody().toJson())) {
                    popUpTo(ShoppingBagScreen.PaymentsForm.route) { inclusive = true }
                }
            }
        )

    }

}