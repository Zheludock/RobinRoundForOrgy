package com.example.arkenkharapp.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.arkenkharapp.R

@Composable
fun BottomBarButton(label: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Gray else Color.Transparent
        )
    ) {
        Image(
            painter = painterResource(id = when (label) {
                "main" -> R.drawable.ic_main
                "book" -> R.drawable.ic_book
                "play" -> R.drawable.ic_play
                "profile" -> R.drawable.ic_profile
                else -> R.drawable.ic_main
            }),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }
}