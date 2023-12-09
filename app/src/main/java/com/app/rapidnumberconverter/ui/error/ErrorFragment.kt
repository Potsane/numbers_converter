package com.app.rapidnumberconverter.ui.error

import androidx.compose.ui.platform.ComposeView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.base.ComposableScreen
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorFragment : BaseRapidNumbersFragment<ErrorViewModel, ViewDataBinding>(),
    ComposableScreen {

    override fun createViewModel(): ErrorViewModel {
        return ViewModelProvider(this, ErrorViewModel.Factory())
            .get(ErrorViewModel::class.java)
    }

    override fun ComposeView.setContent() = setContent {
        NumbersConverterAppTheme {
            ErrorScreen(
                onTryAgain = { viewModel.retry() },
                onGotIt = { viewModel.goHome() }
            )
        }
    }
}