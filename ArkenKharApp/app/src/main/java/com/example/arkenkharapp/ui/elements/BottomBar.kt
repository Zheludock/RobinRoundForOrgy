package com.example.arkenkharapp.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBar(selectedButton: String?, onButtonSelected: (String) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomAppBar(containerColor = Color.Transparent) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val buttons = listOf("main", "book", "play", "profile")
                buttons.forEach { button ->
                    BottomBarButton(
                        label = button,
                        isSelected = selectedButton == button,
                        onClick = { onButtonSelected(button) }
                    )
                }
            }
        }
    }
}