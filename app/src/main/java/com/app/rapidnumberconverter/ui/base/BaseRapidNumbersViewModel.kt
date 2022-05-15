package com.app.rapidnumberconverter.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.rapidnumberconverter.ui.common.toSingleEvent

open class BaseRapidNumbersViewModel : ViewModel() {

    private val _uiCommands = MutableLiveData<Any>().toSingleEvent() as MutableLiveData<Any>
    val uiCommands: LiveData<Any> = _uiCommands

    protected fun postUiCommand(command: Any) {
        _uiCommands.postValue(command)
    }
}