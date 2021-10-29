package com.app.rapidnumberconverter.ui.settings

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentSettingsBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class SettingsFragment : BaseRapidNumbersFragment<SettingsViewModel, FragmentSettingsBinding>() {

    override fun getLayoutId() = R.layout.fragment_settings

    override fun createViewModel(): SettingsViewModel {
        return ViewModelProvider(this, SettingsViewModel.Factory())
            .get(SettingsViewModel::class.java)
    }
}