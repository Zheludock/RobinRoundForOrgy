package com.example.arkenkharapp.ui.sections

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.arkenkharapp.SpellViewModel
import com.example.arkenkharapp.utils.SpellsRow


@Composable
fun SpellsSection(viewModel: SpellViewModel) {
    val spells = viewModel.spells

    LazyColumn {
        items(spells) { spell ->
            SpellsRow(spell, expanded = (viewModel.expandedSpellName == spell.name)) {
                viewModel.toggleItemExpansion(spell.name)
            }
        }
    }
}