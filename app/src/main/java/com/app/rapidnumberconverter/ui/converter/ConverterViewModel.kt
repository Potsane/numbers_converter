package com.app.rapidnumberconverter.ui.converter

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import javax.inject.Inject

class ConverterViewModel @Inject constructor() : BaseRapidNumbersViewModel(),
    AdapterView.OnItemSelectedListener {

    val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")

    fun convert(): String {
        return Integer.toHexString(10)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}