package com.app.rapidnumberconverter.ui.error

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ErrorViewModel @Inject constructor() : BaseRapidNumbersViewModel()  {

    class Factory : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ErrorViewModel() as T
        }
    }
}