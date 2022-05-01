package com.app.rapidnumberconverter.ui.learn

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentLearnBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class LearnFragment : BaseRapidNumbersFragment<LearnViewModel, FragmentLearnBinding>() {

    override fun getLayoutId() = R.layout.fragment_learn

    override fun createViewModel(): LearnViewModel {
        return ViewModelProvider(this, LearnViewModel.Factory())[LearnViewModel::class.java]
    }
}