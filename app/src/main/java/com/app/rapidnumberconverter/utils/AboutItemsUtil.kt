package com.app.rapidnumberconverter.utils

import com.app.rapidnumberconverter.common.AboutCardItem
import com.app.rapidnumberconverter.common.AboutCardItemType

val aboutItems = listOf(
    AboutCardItem(
        title = "License info",
        description = "Open source licensing.",
        primaryButton = "View more",
        type = AboutCardItemType.LICENSE
    ),
    AboutCardItem(
        title = "Share the app",
        description = "Love using this app, feel free to share with those around you.",
        primaryButton = "Share",
        type = AboutCardItemType.SHARE_APP
    ),
    AboutCardItem(
        title = "Rate us",
        description = "Love using this app, please give us a thumbs up on the Google Play Store.",
        primaryButton = "Rate the app",
        type = AboutCardItemType.RATE_US
    ),
    AboutCardItem(
        title = "Support us",
        description = "Love the app, you can help us keep going by donating to us.",
        primaryButton = "Buy us coffee",
        type = AboutCardItemType.SUPPORT_APP
    )
)