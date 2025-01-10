package com.example.arkenkharapp.ui.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun BookSection(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Магия", Modifier.clickable(onClick = {
            navController.navigate("magicScreen")
        }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Места", Modifier.clickable(onClick = {
            navController.navigate("placesScreen")
        }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Существа", Modifier.clickable(onClick = {
            navController.navigate("npcScreen")
        }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Артефакты", Modifier.clickable(onClick = {
            navController.navigate("artefactsScreen")
        }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
    }
}