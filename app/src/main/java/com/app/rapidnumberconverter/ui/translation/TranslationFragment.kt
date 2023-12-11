package com.app.rapidnumberconverter.ui.translation

import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.base.ComposableScreen
import com.app.rapidnumberconverter.ui.common.showDialog
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TranslationFragment : BaseRapidNumbersFragment<TranslationViewModel>() {

    override fun createViewModel(): TranslationViewModel {
        return ViewModelProvider(
            this,
            TranslationViewModel.Factory()
        )[TranslationViewModel::class.java]
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is ShowInvalidTextFormatDialog -> showInvalidNumberFormatDialog()
            else -> super.onUiCommands(command)
        }
    }

    private fun showInvalidNumberFormatDialog() {
        hideKeyBoard()
        showDialog(
            dialogTitle = "Invalid format",
            dialogMessage = "Ensure the text is in the correct format",
            context = requireContext()
        )
    }

    override fun ComposeView.setContent() = setContent {
        NumbersConverterAppTheme {
            TranslationScreen(
                viewModel
            )
        }
    }
}