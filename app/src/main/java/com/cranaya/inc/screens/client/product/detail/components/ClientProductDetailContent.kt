package com.cranaya.inc.screens.client.product.detail.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cranaya.inc.components.DefaultButton
import com.cranaya.inc.components.DotsIndicator
import com.cranaya.inc.components.SliderView
import com.cranaya.inc.screens.client.product.detail.ClientProductDetailViewModel
import com.cranaya.inc.ui.theme.Gray100
import com.cranaya.inc.ui.theme.Gray200
import com.cranaya.inc.ui.theme.Gray700
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientProductDetailContent(
    paddingValues: PaddingValues,
    viewModel: ClientProductDetailViewModel = hiltViewModel()
) {

    val state = rememberPagerState()
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Column {
            SliderView(state = state, images = viewModel.productImages)
            Spacer(modifier = Modifier.height(4.dp))
            DotsIndicator(totalDots = viewModel.productImages.size, selectedIndex = state.currentPage)
        }
        
        Card(
            modifier = Modifier.padding(top = 310.dp),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
           Column(
               modifier = Modifier.padding(20.dp),
           ) {
               Text(
                   text = viewModel.product.name,
                   fontWeight = FontWeight.Bold,
                   fontSize = 18.sp
               )

               Divider(
                   modifier = Modifier.padding(vertical = 10.dp),
                   color = Gray100
               )

               Text(
                   modifier = Modifier.padding(bottom = 7.dp),
                   text = "Description",
                   fontWeight = FontWeight.Bold,
                   fontSize = 16.sp
               )

               Text(
                   text = viewModel.product.description,
                   fontSize = 15.sp
               )

               Divider(
                   modifier = Modifier.padding(vertical = 10.dp),
                   color = Gray100
               )

               Text(
                   modifier = Modifier.padding(bottom = 7.dp),
                   text = "Precio",
                   fontWeight = FontWeight.Bold,
                   fontSize = 16.sp
               )

               Text(
                   text = viewModel.product.price.toString(),
                   fontSize = 15.sp
               )

               Divider(
                   modifier = Modifier.padding(vertical = 10.dp),
                   color = Gray100
               )

               Text(
                   modifier = Modifier.padding(bottom = 7.dp),
                   text = "Tu orden",
                   fontWeight = FontWeight.Bold,
                   fontSize = 16.sp
               )

               Text(
                   text = "Cantidad: ${viewModel.quantity}",
                   fontSize = 15.sp
               )

               Text(
                   text = "Precio C/U: ${viewModel.price}",
                   fontSize = 15.sp
               )

               Spacer(modifier = Modifier.weight(1f))

               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
                   ) {
                   Card(
                       modifier = Modifier
                           .width(100.dp)
                           .height(35.dp),
                       shape = RoundedCornerShape(10.dp),
                       colors = CardDefaults.cardColors(
                           containerColor = Gray700
                       )
                   ) {
                       Row(
                           modifier = Modifier.fillMaxSize(),
                           horizontalArrangement = Arrangement.SpaceEvenly,
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                           Text(
                               modifier = Modifier
                                   .align(Alignment.CenterVertically)
                                   .clickable { viewModel.remove() },
                               text = "-",
                               fontSize = 18.sp,
                               color = Color.White
                           )
                           Text(
                               modifier = Modifier.align(Alignment.CenterVertically),
                               text = viewModel.quantity.toString(),
                               fontSize = 18.sp,
                               color = Color.White
                           )
                           Text(
                               modifier = Modifier
                                   .align(Alignment.CenterVertically)
                                   .clickable { viewModel.add() },
                               text = "+",
                               fontSize = 18.sp,
                               color = Color.White
                           )
                       }
                   }
                   DefaultButton(
                       modifier = Modifier.width(200.dp),
                       text = "Agregar",
                       onClick = { viewModel.saveItem() }
                   )
               }
           } 
        }
    }
    LaunchedEffect(key1 = state.currentPage) {
        delay(3000)
        var newPosition = state.currentPage + 1
        if (newPosition > viewModel.productImages.size - 1) newPosition = 0
        state.animateScrollToPage(newPosition)
    }
    
}