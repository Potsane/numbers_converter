package com.app.rapidnumberconverter.ui.converter

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import javax.inject.Inject

class ConverterViewModel @Inject constructor() : BaseRapidNumbersViewModel(),
    AdapterView.OnItemClickListener {

    val numberSystems = listOf("Decimal", "Hexadecimal", "Octal", "Binary")

    private val _fromNumberSystem = MutableLiveData("")
    val fromNumberSystem: LiveData<String> = _fromNumberSystem

    private val _toNumberSystem = MutableLiveData("")
    val toNumberSystem: LiveData<String> = _toNumberSystem

    init {
        _fromNumberSystem.value = numberSystems.first()
        _toNumberSystem.value = numberSystems.last()
    }

    fun convert(): String {
        return Integer.toHexString(10)
    }

    fun showMenuItem() {
        postUiCommand(ShowNumbersMenu())
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        _fromNumberSystem.value = numberSystems[position]
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ConverterViewModel() as T
        }
    }
}