package com.app.rapidnumberconverter.ui.translation

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentTranslationBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TranslationFragment :
    BaseRapidNumbersFragment<TranslationViewModel, FragmentTranslationBinding>() {

    override fun getLayoutId() = R.layout.fragment_translation

    override fun createViewModel(): TranslationViewModel {
        return ViewModelProvider(this, TranslationViewModel.Factory())
            .get(TranslationViewModel::class.java)
    }
}