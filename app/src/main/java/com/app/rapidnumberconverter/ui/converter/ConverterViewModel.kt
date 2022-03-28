package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.common.NumberSystem
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.ui.base.HideKeyboard
import com.app.rapidnumberconverter.utils.convertDecimal
import javax.inject.Inject

class ConverterViewModel @Inject constructor() : BaseRapidNumbersViewModel() {

    private val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")
    val convertingValue = MutableLiveData<String>()

    private val _fromNumberSystem = MutableLiveData("")
    val fromNumberSystem: LiveData<String> = _fromNumberSystem

    private val _toNumberSystem = MutableLiveData("")
    val toNumberSystem: LiveData<String> = _toNumberSystem

    private val _convertedValue = MutableLiveData("")
    val convertedValue: LiveData<String> = _convertedValue

    init {
        _fromNumberSystem.value = "Unspecified"
        _toNumberSystem.value = "Unspecified"
        _convertedValue.value = "0.0"
    }

    fun convert() {
        postUiCommand(HideKeyboard())
        val fromNumberSystem = NumberSystem.getEnumForValue(_fromNumberSystem.value.orEmpty())
        val toNumberSystem = NumberSystem.getEnumForValue(_toNumberSystem.value.orEmpty())

        _convertedValue.value = when (fromNumberSystem) {
            NumberSystem.DECIMAL -> {
                convertingValue.value?.let {
                    convertDecimal(toNumberSystem, Integer.valueOf(it))
                } ?: "0.0"
            }
            NumberSystem.OCTAL -> {
                ""
            }
            NumberSystem.BINARY -> {
                ""
            }
            else -> ""
        }
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