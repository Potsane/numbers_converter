package com.app.rapidnumberconverter.ui.learn

import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme
import com.app.rapidnumberconverter.utils.mockLearnItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnFragment : BaseRapidNumbersFragment<LearnViewModel>() {

    override fun createViewModel(): LearnViewModel {
        return ViewModelProvider(this)[LearnViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun ComposeView.setContent() = setContent {
        NumbersConverterAppTheme {
            LearnScreen(mockLearnItems) { viewModel.onMoreButtonClick(it) }
        }
    }
}