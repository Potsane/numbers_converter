package com.app.rapidnumberconverter.bindings

import android.content.Context
import android.view.View
import com.app.rapidnumberconverter.common.LearnCardItemClickListener
import com.app.rapidnumberconverter.common.LearnCardItem
import com.app.rapidnumberconverter.ui.common.CollapsibleCard

fun createExpandableCard(
    context : Context,
    item : LearnCardItem,
    clickListener : LearnCardItemClickListener
) : View {
    return CollapsibleCard(context).also {
        it.item = item
        it.clickListener = clickListener
    }
}