package com.app.rapidnumberconverter.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseRapidNumbersViewModel : ViewModel(){

    private val _uiCommands : MutableLiveData<Any> = MutableLiveData()
    val uiCommands : LiveData<Any> = _uiCommands

    protected fun postUiCommand(command : Any){
        _uiCommands.postValue(command)
    }
}