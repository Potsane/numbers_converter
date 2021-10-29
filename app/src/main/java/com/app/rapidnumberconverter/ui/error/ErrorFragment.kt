package com.app.rapidnumberconverter.ui.error

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentErrorBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorFragment : BaseRapidNumbersFragment<ErrorViewModel, FragmentErrorBinding>() {

    override fun getLayoutId() = R.layout.fragment_error

    override fun createViewModel(): ErrorViewModel {
        return ViewModelProvider(this, ErrorViewModel.Factory())
            .get(ErrorViewModel::class.java)
    }
}