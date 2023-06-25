package com.cranaya.inc.screens.client.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cranaya.domain.category.model.Category

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    categories: List<Category>
) {

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = categories
        ) {
            ClientCategoryListItem(
                navController = navController,
                category = it
            )

        }
    }
}