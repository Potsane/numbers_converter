package com.app.rapidnumberconverter.bindings

import android.R
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter
import android.widget.ArrayAdapter

@BindingAdapter(
    value = ["systems", "itemSelectedListener"]
)
fun setSystems(
    autoCompleteTextView: AutoCompleteTextView,
    systems: List<String>,
    itemSelectedListener: AdapterView.OnItemSelectedListener
) {
    if (systems.isEmpty()) return
    val adapter = ArrayAdapter(autoCompleteTextView.context, R.layout.simple_list_item_1, systems)
    autoCompleteTextView.setAdapter(adapter)
    autoCompleteTextView.onItemSelectedListener = itemSelectedListener
//    autoCompleteTextView.setOnItemClickListener(itemSelectedListener)
}