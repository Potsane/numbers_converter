package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import javax.inject.Inject

class ConverterViewModel @Inject constructor() : BaseRapidNumbersViewModel() {

    fun convert(){
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}