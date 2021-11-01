package com.app.rapidnumberconverter.ui.converter

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentConverterBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class ConverterFragment : BaseRapidNumbersFragment<ConverterViewModel, FragmentConverterBinding>() {

    override fun getLayoutId() = R.layout.fragment_converter

    override fun createViewModel(): ConverterViewModel {
        return ViewModelProvider(this, ConverterViewModel.Factory())
            .get(ConverterViewModel::class.java)
    }
}