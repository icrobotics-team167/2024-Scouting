package com.example.cotcscouting.ui.graphing_testing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class GraphingTestingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the graphing testing view model."
    }
    val text: LiveData<String> = _text
}