package com.app.rapidnumberconverter.bindings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.app.rapidnumberconverter.BR
import com.app.rapidnumberconverter.common.BaseCardItemClickListener
import com.app.rapidnumberconverter.common.LearnCardItem
import com.app.rapidnumberconverter.common.LearnCardItemClickListener

@BindingAdapter(
    value = ["items", "itemsLayout", "itemsClickListener"],
    requireAll = false
)
fun <T> setListItems(
    viewGroup: ViewGroup,
    items: List<T>,
    layout: Int,
    onItemClickListener: BaseCardItemClickListener<T>? = null
) {

    viewGroup.removeAllViews()
    if (items.isEmpty()) return

    val inflater = LayoutInflater.from(viewGroup.context)
    for (i in items.indices) {
        val item = items[i]
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            layout,
            viewGroup,
            true
        )
        onItemClickListener?.let { binding?.setVariable(BR.clickListener, it) }
        binding?.setVariable(BR.item, item)
        binding?.executePendingBindings()
    }
}

@BindingAdapter(
    value = ["cards", "onClickListener"],
    requireAll = true
)
fun setLearnListItems(
    viewGroup: ViewGroup,
    items: List<LearnCardItem>,
    onClickListener: LearnCardItemClickListener
) {

    val context = viewGroup.context ?: return
    viewGroup.removeAllViews()

    items.forEach {
        viewGroup.addView(createExpandableCard(context, it, onClickListener))
    }
}