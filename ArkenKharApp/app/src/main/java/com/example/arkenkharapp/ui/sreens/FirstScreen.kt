package com.example.arkenkharapp.ui.sreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.arkenkharapp.ui.elements.BackgroundImage
import com.example.arkenkharapp.ui.elements.BottomBar
import com.example.arkenkharapp.utils.ContentSection

@Composable
fun FirstScreen(navController: NavHostController, selectedButton: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BackgroundImage()
        Column(Modifier.fillMaxSize()) {
            ContentSection(selectedButton, navController)
            BottomBar(selectedButton) { button ->
                navController.navigate("firstScreen/$button")
            }
        }
    }
}