package com.cranaya.inc.screens.client.address.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.screens.admin.categotry.list.AdminCategoryListViewModel
import com.cranaya.inc.screens.client.address.list.ClientAddressListViewModel

@Composable
fun GetAddress(
    paddingValues: PaddingValues,
    viewModel: ClientAddressListViewModel = hiltViewModel()
) {

    when(val response = viewModel.addressResponse) {
        is Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ClientAddressListContent(paddingValues, addressList = response.data)
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