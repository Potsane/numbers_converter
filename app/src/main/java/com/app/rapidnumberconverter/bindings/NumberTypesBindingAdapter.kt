package com.app.rapidnumberconverter.bindings

import android.R
import android.text.InputType
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter
import android.widget.ArrayAdapter
import com.app.rapidnumberconverter.common.NumberSystem
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter(value = ["systems", "itemSelectedListener"])
fun setSystems(
    autoCompleteTextView: AutoCompleteTextView,
    systems: List<String>,
    itemSelectedListener: AdapterView.OnItemSelectedListener
) {
    if (systems.isEmpty()) return
    val adapter = ArrayAdapter(autoCompleteTextView.context, R.layout.simple_list_item_1, systems)
    autoCompleteTextView.setAdapter(adapter)
    autoCompleteTextView.onItemSelectedListener = itemSelectedListener
}

@BindingAdapter("keyboardType")
fun setKeyboardType(textInputEditText: TextInputEditText?, numberSystemId: String) {
    val numberSystem = NumberSystem.getEnumForValue(numberSystemId)
    textInputEditText?.let {
        it.inputType = when (numberSystem) {
            NumberSystem.HEXADECIMAL -> InputType.TYPE_CLASS_TEXT
            else -> InputType.TYPE_CLASS_NUMBER
        }
    } ?: return
}