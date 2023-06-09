package com.cranaya.inc.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cranaya.inc.screens.auth.login.components.LoginContent
import com.cranaya.inc.ui.theme.RedworkTheme

@Composable
fun LoginScreen() {
    Scaffold { paddingValues ->
        LoginContent(paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    RedworkTheme {
        LoginScreen()
    }
}