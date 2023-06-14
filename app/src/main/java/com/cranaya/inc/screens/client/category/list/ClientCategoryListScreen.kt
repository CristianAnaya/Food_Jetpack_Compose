package com.cranaya.inc.screens.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.cranaya.inc.screens.client.category.list.components.ClientCategoryListContent
import com.cranaya.inc.screens.profile.components.ProfileContent

@Composable
fun ClientCategoryListScreen() {

    Scaffold() {
        ClientCategoryListContent(paddingValues = it)
    }

}