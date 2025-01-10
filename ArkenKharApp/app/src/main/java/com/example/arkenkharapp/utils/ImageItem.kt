package com.example.arkenkharapp.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ImageItem(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Сохраняем пропорции
            .clickable { /* Действие при клике */ }
    )
}