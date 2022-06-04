package com.app.rapidnumberconverter.ui.error

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel

class ErrorViewModel : BaseRapidNumbersViewModel() {

    fun retry() = goBack()

    fun goHome() = navigate(ErrorFragmentDirections.errorToHome())

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ErrorViewModel() as T
        }
    }
}