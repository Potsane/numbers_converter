package com.app.rapidnumberconverter.ui.learn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.LearnCardItem
import com.app.rapidnumberconverter.common.LearnCardItemClickListener
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.learnArticles

class LearnViewModel : BaseRapidNumbersViewModel(), LearnCardItemClickListener {

    val items = learnArticles

    override fun onMoreButtonClick(item: LearnCardItem) {
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LearnViewModel() as T
        }
    }
}