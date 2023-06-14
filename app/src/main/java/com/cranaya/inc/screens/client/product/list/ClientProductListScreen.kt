package com.cranaya.inc.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.cranaya.inc.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen() {

    Scaffold() {
        ClientProductListContent(paddingValues = it)
    }

}