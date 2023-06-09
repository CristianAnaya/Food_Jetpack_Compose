package com.cranaya.inc.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cranaya.inc.ui.theme.Blue500
import com.cranaya.inc.ui.theme.RedworkTheme

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Blue500,
    icon: ImageVector = Icons.Default.ArrowForward
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    RedworkTheme {
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            text = "Sign in",
            onClick = {  }
        )
    }
}