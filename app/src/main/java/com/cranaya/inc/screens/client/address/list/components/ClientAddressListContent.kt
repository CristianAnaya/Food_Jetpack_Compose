package com.cranaya.inc.screens.client.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cranaya.domain.address.model.Address

@Composable
fun ClientAddressListContent(paddingValues: PaddingValues, addressList: List<Address>) {

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        items(
            items = addressList
        ) {
            ClientAddressListItem(address = it)
        }
    }

}