package com.app.rapidnumberconverter.common

data class AboutCardItem(
    var title: String,
    var description: String,
    var primaryButton: String,
    var secondaryButton: String? = null,
    var type: AboutCardItemType
)

enum class AboutCardItemType {
    RATE_US,
    SHARE_APP,
    SUPPORT_APP,
    LICENSE
}
