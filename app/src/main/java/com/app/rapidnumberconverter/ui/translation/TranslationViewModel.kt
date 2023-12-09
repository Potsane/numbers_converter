package com.app.rapidnumberconverter.ui.translation

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.TranslationDirection
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.TranslationUtils
import com.app.rapidnumberconverter.utils.prettyBinary
import com.app.rapidnumberconverter.utils.toBinary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TranslationViewModel : BaseRapidNumbersViewModel() {

    val directions = listOf("Text to Binary", "Binary to Text")

    private val _translationDirection = MutableStateFlow(directions.first())
    val translationDirection: StateFlow<String> = _translationDirection

    fun onTranslate(plainText: String) {
        if (plainText.isNotEmpty()) {
            translateText(plainText)
        }
    }

    fun onMenuItemClick(selectedOption: String) {
        _translationDirection.value = selectedOption
    }

    private fun translateText(plainText: String) {
        val directionType = TranslationDirection.getEnumForValue(_translationDirection.value)
        if (directionType == TranslationDirection.BINARY_TO_TEXT) {
            try {
                val text = TranslationUtils.translateBinary(plainText.trim())
                postUiCommand(ShowTranslationResult(text))
            } catch (exception: Exception) {
                postUiCommand(ShowInvalidTextFormatDialog())
            }
        } else if (directionType == TranslationDirection.TEXT_TO_BINARY) {
            val translatedText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                plainText.toBinary().prettyBinary(8, " ")
            else plainText.toBinary()
            postUiCommand(ShowTranslationResult(translatedText))
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TranslationViewModel() as T
        }
    }
}