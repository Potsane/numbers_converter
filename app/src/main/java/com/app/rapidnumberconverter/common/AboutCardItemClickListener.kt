package com.app.rapidnumberconverter.common

interface AboutCardItemClickListener : BaseCardItemClickListener<AboutCardItem> {
    fun onPrimaryButtonClick(item: AboutCardItem)
    fun onSecondaryButtonClick(item: AboutCardItem)
}