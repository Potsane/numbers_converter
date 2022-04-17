package com.app.rapidnumberconverter.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.AboutCardItem
import com.app.rapidnumberconverter.common.AboutCardItemClickListener
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.aboutItems

class AboutViewModel : BaseRapidNumbersViewModel(), AboutCardItemClickListener {

    val listItems = aboutItems

    override fun onPrimaryButtonClick(item: AboutCardItem) {
    }

    override fun onSecondaryButtonClick(item: AboutCardItem) {
    }

    override fun onCardClick(item: AboutCardItem) {
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AboutViewModel() as T
        }
    }
}

