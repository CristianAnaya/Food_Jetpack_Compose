package com.cranaya.inc.screens.admin.product.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.admin.product.create.AdminProductCreateViewModel
import com.cranaya.inc.screens.admin.product.update.AdminProductUpdateViewModel

@Composable
fun UpdateProduct(viewModel: AdminProductUpdateViewModel = hiltViewModel()) {

   when(val response = viewModel.productResponse) {
       is Resource.Loading -> {
           ProgressBar()
       }
       is Resource.Success -> {
           Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamente", Toast.LENGTH_LONG).show()
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