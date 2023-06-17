package com.cranaya.inc.screens.profile.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.profile.update.components.ProfileUpdateContent
import com.cranaya.inc.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(
    navController: NavHostController,
    userParam: String
) {
    Log.d("ProfileUpdateScreen", "ProfileUpdateScreen: $userParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        }
    ) {
        ProfileUpdateContent(paddingValues = it)
    }
    
    UpdateUser()

}