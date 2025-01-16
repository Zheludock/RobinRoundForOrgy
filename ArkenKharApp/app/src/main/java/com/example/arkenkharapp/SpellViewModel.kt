package com.example.arkenkharapp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.arkenkharapp.utils.Spell
import com.example.arkenkharapp.utils.loadSpellsFromJson

class SpellViewModel(application: Application) : AndroidViewModel(application) {
    private val _spells = mutableStateListOf<Spell>()
    val spells: List<Spell> get() = _spells

    var expandedSpellName by mutableStateOf<String?>(null)

    fun loadSpells() {
        _spells.clear()
        _spells.addAll(loadSpellsFromJson(getApplication()))
    }

    fun toggleItemExpansion(spellName: String) {
        expandedSpellName = if (expandedSpellName == spellName) null else spellName
    }
}