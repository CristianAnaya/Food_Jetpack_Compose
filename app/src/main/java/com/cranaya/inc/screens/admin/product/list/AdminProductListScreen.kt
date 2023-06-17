package com.cranaya.inc.screens.admin.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.cranaya.inc.screens.admin.product.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen() {

    Scaffold() {
        AdminProductListContent(paddingValues = it)
    }

}