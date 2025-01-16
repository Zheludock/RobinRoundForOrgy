package com.example.arkenkharapp.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SpellsRow(spell: Spell, expanded: Boolean, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable(onClick = onClick)) {
        Text(text = spell.name)

        if (expanded) {
            Text(text = "Описание: ${spell.description}")
        }
        HorizontalDivider()
    }
}