package com.app.rapidnumberconverter.bindings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.app.rapidnumberconverter.common.BaseCardItemClickListener
import com.app.rapidnumberconverter.BR

@BindingAdapter(
    value = ["items", "itemsLayout", "itemsClickListener"],
    requireAll = false
)
fun <T> setListItems(
    viewGroup: ViewGroup,
    items: List<T>,
    layout: Int,
    onItemClickListener: BaseCardItemClickListener<T>
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
        binding?.setVariable(BR.clickListener, onItemClickListener)
        binding?.setVariable(BR.item, item)
        binding?.executePendingBindings()
    }
}