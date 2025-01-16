package com.example.arkenkharapp.ui.sreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.arkenkharapp.SpellViewModel
import com.example.arkenkharapp.ui.elements.BackgroundImage
import com.example.arkenkharapp.ui.elements.BottomBar
import com.example.arkenkharapp.ui.sections.SpellsSection
import com.example.arkenkharapp.utils.loadSpellsFromJson

@Composable
fun SpellsScreen(navController: NavHostController) {
    var selectedButton: String? by remember { mutableStateOf(null) }
    val spellViewModel: SpellViewModel = viewModel()

    Box(Modifier.fillMaxSize()) {
        BackgroundImage()
        Column(Modifier.fillMaxSize()) {
            Text(
                text = "В разработке",
                color = Color.White,
                fontSize = 42.sp,
            )
            LaunchedEffect(Unit) {
                spellViewModel.loadSpells()
            }
            val viewModel: SpellViewModel = viewModel()
            viewModel.loadSpells(loadSpellsFromJson(context)) // Загрузите заклинания из JSON, если необходимо

            SpellsSection(viewModel)
            SpellsSection(viewModel = spellViewModel)
            BottomBar(selectedButton = selectedButton) { button ->
                navController.navigate("firstScreen/$button")
            }
        }
    }
}