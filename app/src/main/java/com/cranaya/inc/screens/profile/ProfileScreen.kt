package com.cranaya.inc.screens.profile

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.cranaya.inc.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen() {

    Scaffold() {
        ProfileContent(paddingValues = it)
    }

}