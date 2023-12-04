package com.app.rapidnumberconverter.ui.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.common.AboutCardItem
import com.app.rapidnumberconverter.common.AboutCardItemType
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersViewModel
import com.app.rapidnumberconverter.utils.Constants.APP_URL
import com.app.rapidnumberconverter.utils.Constants.OPEN_SOURCE_URL
import com.app.rapidnumberconverter.utils.Constants.PAY_PAL_URL
import com.app.rapidnumberconverter.utils.Constants.SHARE_APP_BODY
import com.app.rapidnumberconverter.utils.Constants.SHARE_APP_TITLE

class AboutViewModel : BaseRapidNumbersViewModel() {

     fun onCardClick(item: AboutCardItem) {
        when (item.type) {
            AboutCardItemType.RATE_US -> {
                postUiCommand(LaunchExternalPage(APP_URL))
            }
            AboutCardItemType.SHARE_APP -> {
                postUiCommand(ShareApp(SHARE_APP_TITLE, SHARE_APP_BODY))
            }
            AboutCardItemType.SUPPORT_APP -> {
                postUiCommand(LaunchExternalPage(PAY_PAL_URL))
            }
            AboutCardItemType.LICENSE -> {
                postUiCommand(LaunchExternalPage(OPEN_SOURCE_URL))
            }
        }
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AboutViewModel() as T
        }
    }
}

