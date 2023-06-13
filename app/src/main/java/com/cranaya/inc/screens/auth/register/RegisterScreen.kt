package com.cranaya.inc.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cranaya.inc.components.DefaultTopBar
import com.cranaya.inc.screens.auth.register.components.Register
import com.cranaya.inc.screens.auth.register.components.RegisterContent
import com.cranaya.inc.ui.theme.RedworkTheme

@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Register",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RedworkTheme {
        RegisterScreen(rememberNavController())
    }
}