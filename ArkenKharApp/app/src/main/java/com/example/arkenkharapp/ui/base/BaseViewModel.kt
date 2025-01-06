package com.example.arkenkharapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is base Fragment"
    }
    val text: LiveData<String> = _text
}