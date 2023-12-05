package com.app.rapidnumberconverter.ui.learn

import androidx.compose.ui.platform.ComposeView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.base.ComposableScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LearnFragment : BaseRapidNumbersFragment<LearnViewModel, ViewDataBinding>(),
    ComposableScreen {

    override fun createViewModel(): LearnViewModel {
        return ViewModelProvider(this)[LearnViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun ComposeView.setContent() = setContent {
        viewModel.learnArticles.value?.let {
            LearnScreen(it){

            }
        }
    }
}