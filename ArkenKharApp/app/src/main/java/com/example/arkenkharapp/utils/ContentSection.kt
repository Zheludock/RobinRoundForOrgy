package com.example.arkenkharapp.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.arkenkharapp.ui.sections.BookSection
import com.example.arkenkharapp.ui.sections.MainSection
import com.example.arkenkharapp.ui.sections.PlaySection
import com.example.arkenkharapp.ui.sections.ProfileSection

@Composable
fun ContentSection(selectedButton: String, navController: NavHostController) {
    when (selectedButton) {
        "main" -> MainSection()
        "book" -> BookSection(navController)
        "play" -> PlaySection()
        "profile" -> ProfileSection()
        else -> {}
    }
}
