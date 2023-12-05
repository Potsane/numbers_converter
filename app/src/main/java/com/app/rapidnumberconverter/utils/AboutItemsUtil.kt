package com.app.rapidnumberconverter.utils

import com.app.rapidnumberconverter.common.ContentCardItem
import com.app.rapidnumberconverter.common.ContentCardItemAction
import com.app.rapidnumberconverter.common.ContentCardItemActionType

val aboutItems = listOf(
    ContentCardItem(
        title = "License info",
        description = "Open source licensing.",
        action = ContentCardItemAction(
            name = "View",
            type = ContentCardItemActionType.REDIRECT,
            url = Constants.OPEN_SOURCE_URL
        )
    ),
    ContentCardItem(
        title = "Share the app",
        description = "Love using this app, feel free to share with those around you.",
        action = ContentCardItemAction(
            name = "Share",
            type = ContentCardItemActionType.SHARE,
        )
    ),
    ContentCardItem(
        title = "Rate us",
        description = "Love using this app, please give us a thumbs up on the Google Play Store.",
        action = ContentCardItemAction(
            name = "Rate",
            type = ContentCardItemActionType.REDIRECT,
            url = Constants.APP_URL
        )
    )
  /*  AboutCardItem(
        title = "Support us",
        description = "Love the app, you can help us keep going by donating to us.",
        primaryButton = "Buy us coffee",
        type = AboutCardItemType.SUPPORT_APP
    )*/
)