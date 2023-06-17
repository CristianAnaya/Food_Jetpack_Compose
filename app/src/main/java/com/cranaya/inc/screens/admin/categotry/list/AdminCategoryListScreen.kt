package com.cranaya.inc.screens.admin.categotry.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.cranaya.inc.screens.admin.categotry.list.components.AdminCategoryListContent
import com.cranaya.inc.screens.client.category.list.components.ClientCategoryListContent

@Composable
fun AdminCategoryListScreen() {

    Scaffold() {
        AdminCategoryListContent(paddingValues = it)
    }

}