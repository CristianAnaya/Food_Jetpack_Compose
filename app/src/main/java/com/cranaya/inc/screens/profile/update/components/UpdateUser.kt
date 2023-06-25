package com.cranaya.inc.screens.profile.update.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.navigation.Graph
import com.cranaya.inc.screens.auth.login.LoginViewModel
import com.cranaya.inc.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(viewModel: ProfileUpdateViewModel = hiltViewModel()) {

   when(val response = viewModel.updateResponse) {
       is Resource.Loading -> {
           ProgressBar()
       }
       is Resource.Success -> {
           viewModel.updateUserSession(response.data)
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