package com.cranaya.inc.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.components.ProgressBar
import com.cranaya.inc.navigation.screen.AuthScreen
import com.cranaya.inc.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()) {

    when (val response = viewModel.registerResponse) {
        is Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
//                navController.navigate(route = AuthScreen.Home.route) {
//                    popUpTo(AuthScreen.Login.route) { inclusive = true }
//                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}