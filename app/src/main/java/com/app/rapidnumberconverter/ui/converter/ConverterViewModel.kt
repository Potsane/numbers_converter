package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.common.NumberInputListener
import com.app.rapidnumberconverter.common.NumberSystem
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.ui.base.HideKeyboard
import com.app.rapidnumberconverter.ui.translation.ShowTranslationResult
import com.app.rapidnumberconverter.utils.*

class ConverterViewModel : BaseRapidNumbersViewModel(), NumberInputListener {

     val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")

    private val _fromNumberSystem = MutableLiveData("")
    val fromNumberSystem: LiveData<String> = _fromNumberSystem

    private val _toNumberSystem = MutableLiveData("")
    val toNumberSystem: LiveData<String> = _toNumberSystem

    val convertingValue = MutableLiveData<String>()

    init {
        _fromNumberSystem.value = numberSystems.first()
        _toNumberSystem.value = numberSystems.last()
    }

    fun convert() {
        postUiCommand(HideKeyboard())
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

    //when menu icon is clicked (DELETE)
    fun showMenuItem(conversionContext: ConversionContext) {
        when (conversionContext) {
            ConversionContext.CONVERT_FROM -> {
                postUiCommand(ShowFromNumbersMenu(conversionContext, numberSystems))
            }
            ConversionContext.CONVERT_TO -> {
                postUiCommand(ShowFromNumbersMenu(conversionContext, numberSystems))
            }
        }
    }

    //item is selected
    fun onMenuItemClick(selectedOption: String, conversionContext: ConversionContext) {
        when (conversionContext) {
            ConversionContext.CONVERT_FROM -> _fromNumberSystem.value = selectedOption
            ConversionContext.CONVERT_TO -> _toNumberSystem.value = selectedOption
        }
    }

    override fun onClearText() = convertingValue.postValue("")

    override fun onCopyText() = postUiCommand(CopyText(convertingValue.value.orEmpty()))

    override fun onPasteText() = postUiCommand(PasteText())

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}