package com.app.rapidnumberconverter.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class SettingsViewModel : BaseRapidNumbersViewModel() {

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SettingsViewModel() as T
        }
    }
}

