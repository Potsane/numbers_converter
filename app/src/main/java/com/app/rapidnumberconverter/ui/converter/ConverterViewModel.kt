package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import javax.inject.Inject

class ConverterViewModel @Inject constructor() : BaseRapidNumbersViewModel() {

    private val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")

    private val _fromNumberSystem = MutableLiveData("")
    val fromNumberSystem: LiveData<String> = _fromNumberSystem

    private val _toNumberSystem = MutableLiveData("")
    val toNumberSystem: LiveData<String> = _toNumberSystem

    init {
        _fromNumberSystem.value = "Unspecified"
        _toNumberSystem.value = "Unspecified"
    }

    fun convert(): String {
        return Integer.toHexString(10)
    }

    fun showMenuItem(conversionContext: ConversionContext) {
        when (conversionContext) {
            ConversionContext.CONVERT_FROM -> {
                postUiCommand(
                    ShowFromNumbersMenu(
                        conversionContext,
                        numberSystems.filterNot { it == _toNumberSystem.value }
                    )
                )
            }
            ConversionContext.CONVERT_TO -> {
                postUiCommand(
                    ShowFromNumbersMenu(
                        conversionContext,
                        numberSystems.filterNot { it == _fromNumberSystem.value }
                    )
                )
            }
        }
    }

    fun onMenuItemClick(selectedOption: String, conversionContext: ConversionContext) {
        when (conversionContext) {
            ConversionContext.CONVERT_FROM -> _fromNumberSystem.value = selectedOption
            ConversionContext.CONVERT_TO -> _toNumberSystem.value = selectedOption
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}