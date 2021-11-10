package com.app.rapidnumberconverter.ui.calculator

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentCalculatorBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class CalculatorFragment :
    BaseRapidNumbersFragment<CalculatorViewModel, FragmentCalculatorBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val keyboard = binding.keyboard
        val editText = binding.calculatorText.also {
            it.setRawInputType(InputType.TYPE_CLASS_TEXT)
            it.setTextIsSelectable(true)
        }
        val inputConnection = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(inputConnection)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutId() = R.layout.fragment_calculator

    override fun createViewModel(): CalculatorViewModel {
        return ViewModelProvider(this, CalculatorViewModel.Factory())
            .get(CalculatorViewModel::class.java)
    }
}