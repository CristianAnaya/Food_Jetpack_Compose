package com.cranaya.inc.screens.client.shoppingBag.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cranaya.domain.shoppingBag.model.ShoppingBag

@Composable
fun ClientShoppingBagContent(
    paddingValues: PaddingValues,
    shoppingBag: MutableList<ShoppingBag>
) {
    
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        items(
            items = shoppingBag
        ) {
            ClientShoppingBagItem(shoppingBag = it)
        }
    }
    
}