package com.app.rapidnumberconverter.common

data class ContentCardItem(
    var title: String,
    var description: String,
    val action: ContentCardItemAction
)

data class ContentCardItemAction(
    val name: String,
    val type: ContentCardItemActionType,
    val url: String = ""
)

enum class ContentCardItemActionType {
    SHARE, REDIRECT
}