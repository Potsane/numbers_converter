package com.app.rapidnumberconverter.ui.translation

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.prettyBinary
import com.app.rapidnumberconverter.utils.toBinary

class TranslationViewModel : BaseRapidNumbersViewModel() {
    private val _translatedText = MutableLiveData<String>()
    val translatedText: LiveData<String> = _translatedText

    val plainText = MutableLiveData("")

    fun onTranslate() {
        _translatedText.value = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            plainText.value?.toBinary()?.prettyBinary(8, " ")
        else plainText.value?.toBinary()
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TranslationViewModel() as T
        }
    }
}