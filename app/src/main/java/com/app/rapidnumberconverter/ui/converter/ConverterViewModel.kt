package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.common.NumberSystem
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.ui.base.HideKeyboard
import com.app.rapidnumberconverter.ui.translation.ShowTranslationResult
import com.app.rapidnumberconverter.utils.convertBinary
import com.app.rapidnumberconverter.utils.convertDecimal
import com.app.rapidnumberconverter.utils.convertHexadecimal
import com.app.rapidnumberconverter.utils.convertOctal
import com.app.rapidnumberconverter.utils.isValidNumberInput

class ConverterViewModel : BaseRapidNumbersViewModel() {

    val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")
    private var convertingValue = MutableLiveData<String>()

    private val _fromNumberSystem = MutableLiveData("")
    val fromNumberSystem: LiveData<String> = _fromNumberSystem

    private val _toNumberSystem = MutableLiveData("")
    val toNumberSystem: LiveData<String> = _toNumberSystem

    init {
        _fromNumberSystem.value = numberSystems.first()
        _toNumberSystem.value = numberSystems.last()
    }

    fun convert(value: String) {
        postUiCommand(HideKeyboard())
        convertingValue.value = value
        val fromNumberSystem = NumberSystem.getEnumForValue(_fromNumberSystem.value.orEmpty())
        val toNumberSystem = NumberSystem.getEnumForValue(_toNumberSystem.value.orEmpty())

        if (!isValidNumberInput(convertingValue.value, fromNumberSystem)) {
            postUiCommand(ShowInvalidNumberFormatDialog())
            return
        }

        if (toNumberSystem == fromNumberSystem) {
            postUiCommand(ShowTranslationResult(convertingValue.value ?: "Something went wrong!"))
            return
        }

        val convertedValue = convertingValue.value?.let {
            when (fromNumberSystem) {
                NumberSystem.DECIMAL -> convertDecimal(toNumberSystem, it)
                NumberSystem.BINARY -> convertBinary(toNumberSystem, it)
                NumberSystem.OCTAL -> convertOctal(toNumberSystem, it)
                NumberSystem.HEXADECIMAL -> convertHexadecimal(toNumberSystem, it)
            }
        } ?: "0.0"
        postUiCommand(ShowTranslationResult(convertedValue, "Converted Value"))
    }

    fun onMenuItemClick(selectedOption: String, conversionContext: ConversionContext) {
        when (conversionContext) {
            ConversionContext.CONVERT_FROM -> _fromNumberSystem.value = selectedOption
            ConversionContext.CONVERT_TO -> _toNumberSystem.value = selectedOption
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}