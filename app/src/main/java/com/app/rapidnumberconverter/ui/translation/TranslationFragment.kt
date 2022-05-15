package com.app.rapidnumberconverter.ui.translation

import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentTranslationBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.common.showDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TranslationFragment :
    BaseRapidNumbersFragment<TranslationViewModel, FragmentTranslationBinding>() {

    override fun getLayoutId() = R.layout.fragment_translation

    override fun createViewModel(): TranslationViewModel {
        return ViewModelProvider(
            this,
            TranslationViewModel.Factory()
        )[TranslationViewModel::class.java]
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is ShowTranslationDirectionMenu -> showDirectionsMenuItem(command.menuItems)
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

    private fun showDirectionsMenuItem(items: List<String>) {
        showPopupMenuItem(items, binding.textViewDirection) { viewModel.onMenuItemClick(it) }
    }
}