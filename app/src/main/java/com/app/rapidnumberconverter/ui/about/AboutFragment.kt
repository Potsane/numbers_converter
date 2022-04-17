package com.app.rapidnumberconverter.ui.about

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentAboutBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class AboutFragment : BaseRapidNumbersFragment<AboutViewModel, FragmentAboutBinding>() {

    override fun getLayoutId() = R.layout.fragment_about

    override fun createViewModel(): AboutViewModel {
        return ViewModelProvider(this, AboutViewModel.Factory())[AboutViewModel::class.java]
    }
}