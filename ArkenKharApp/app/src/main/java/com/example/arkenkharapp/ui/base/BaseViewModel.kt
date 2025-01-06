package com.example.arkenkharapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "@string/title_base"
    }
    val text: LiveData<String> = _text
}