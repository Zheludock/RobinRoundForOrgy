package com.example.arkenkharapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arkenkharapp.ui.sreens.ArtefactsScreen
import com.example.arkenkharapp.ui.sreens.FirstScreen
import com.example.arkenkharapp.ui.sreens.MagicScreen
import com.example.arkenkharapp.ui.sreens.NpcScreen
import com.example.arkenkharapp.ui.sreens.PlacesScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "firstScreen/main") {
        composable("firstScreen/{selectedButton}") { backStackEntry ->
            val selectedButton = backStackEntry.arguments?.getString("selectedButton") ?: "main"
            FirstScreen(navController, selectedButton)
        }
        composable("magicScreen") { MagicScreen(navController) }
        composable("placesScreen") { PlacesScreen(navController) }
        composable("npcScreen") { NpcScreen(navController) }
        composable("artefactsScreen") { ArtefactsScreen(navController) }
    }
}