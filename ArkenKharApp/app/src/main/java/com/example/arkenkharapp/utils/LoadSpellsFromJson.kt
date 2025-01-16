package com.example.arkenkharapp.utils

import android.content.Context
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.InputStreamReader

fun loadSpellsFromJson(): List<Spell> {
    val inputStream = context.assets.open("spells.json")
    val reader = InputStreamReader(inputStream)
    val spellListType = object : TypeToken<List<Spell>>() {}.type
    return Gson().fromJson(reader, spellListType)
}