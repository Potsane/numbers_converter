package com.app.rapidnumberconverter.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.common.ContentCardItemActionType
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.Constants.SHARE_APP_BODY
import com.app.rapidnumberconverter.utils.Constants.SHARE_APP_TITLE

class AboutViewModel : BaseRapidNumbersViewModel() {

    fun onCardClick(item: ContentCardItem) {
        val action = item.action
        when (action.type) {
            ContentCardItemActionType.SHARE -> postUiCommand(
                ShareApp(SHARE_APP_TITLE, SHARE_APP_BODY)
            )

            ContentCardItemActionType.REDIRECT -> postUiCommand(LaunchExternalPage(action.url))
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AboutViewModel() as T
        }
    }
}

