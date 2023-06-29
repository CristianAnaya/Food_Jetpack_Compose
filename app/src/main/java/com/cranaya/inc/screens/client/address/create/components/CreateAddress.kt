package com.cranaya.inc.screens.client.address.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.client.address.create.ClientAddressCreateViewModel

@Composable
fun CreateAddress(viewModel: ClientAddressCreateViewModel = hiltViewModel()) {

   when(val response = viewModel.addressResponse) {
       is Resource.Loading -> {
           ProgressBar()
       }
       is Resource.Success -> {
           viewModel.cleanForm()
           Toast.makeText(LocalContext.current, "La dirección se ha creado correctamente", Toast.LENGTH_LONG).show()
       }
       is Resource.Failure -> {
           Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
       }
       else -> {
           if (response != null)
            Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
       }
   }

}