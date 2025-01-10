package com.example.arkenkharapp.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.arkenkharapp.R


@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.bg_all),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}
