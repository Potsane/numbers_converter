package com.app.rapidnumberconverter.ui.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel

class CalculatorViewModel : BaseRapidNumbersViewModel() {

    class Factory : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CalculatorViewModel() as T
        }
    }
}