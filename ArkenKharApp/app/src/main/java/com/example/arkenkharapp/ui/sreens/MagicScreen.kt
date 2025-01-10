package com.example.arkenkharapp.ui.sreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.arkenkharapp.ui.elements.BackgroundImage
import com.example.arkenkharapp.ui.elements.BottomBar
import com.example.arkenkharapp.ui.elements.ImageGrid

@Composable
fun MagicScreen(navController: NavHostController) {
    var selectedButton: String? by remember { mutableStateOf(null) }
    Box(Modifier.fillMaxSize()) {
        BackgroundImage()
        Column(Modifier.fillMaxSize()) {
            Text(text = "Магия", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            ImageGrid(Modifier.weight(1.0f))
            BottomBar(selectedButton = selectedButton) { button ->
                navController.navigate("firstScreen/$button")
            }
        }
    }
}