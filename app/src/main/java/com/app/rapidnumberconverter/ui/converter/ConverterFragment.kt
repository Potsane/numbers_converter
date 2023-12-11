package com.app.rapidnumberconverter.ui.converter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.common.showDialog
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

class ConverterFragment : BaseRapidNumbersFragment<ConverterViewModel>() {

    private val clipboardManager by lazy {
        requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is ShowInvalidNumberFormatDialog -> showInvalidNumberFormatDialog()
            is CopyText -> copyText(command.text)
            is PasteText -> pasteText()
            else -> super.onUiCommands(command)
        }
    }

    override fun createViewModel(): ConverterViewModel {
        return ViewModelProvider(
            this,
            ConverterViewModel.Factory()
        )[ConverterViewModel::class.java]
    }

    private fun showInvalidNumberFormatDialog() {
        hideKeyBoard()
        showDialog(
            dialogTitle = "Number format",
            dialogMessage = "Ensure the number is in the correct format",
            context = requireContext()
        )
    }

    private fun copyText(text: String) {
        val clip = ClipData.newPlainText("result", text)
        clipboardManager?.setPrimaryClip(clip)
    }

    private fun pasteText(): String {
        val pasteData: ClipData? = clipboardManager?.primaryClip
        val item = pasteData?.getItemAt(0)
        return item?.text.toString()
    }

    override fun ComposeView.setContent() = setContent {
        NumbersConverterAppTheme {
            ConverterScreen(
                viewModel = viewModel,
                onCopyText = { ex -> copyText(ex) },
                onPasteText = { pasteText() }
            )
        }
    }
}