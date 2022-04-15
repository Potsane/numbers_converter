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
        return ViewModelProvider(
            this,
            TranslationViewModel.Factory()
        )[TranslationViewModel::class.java]
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is TranslateText -> showTranslationResultDialog(command.text)
            is ShowTranslationDirectionMenu -> showDirectionsMenuItem(command.menuItems)
            else -> super.onUiCommands(command)
        }
    }

    private fun showTranslationResultDialog(text: String) {
        val bottomSheetFragment = TranslationResultDialogFragment.newInstance(text)
        bottomSheetFragment.show(parentFragmentManager, null)
    }

    private fun showDirectionsMenuItem(items: List<String>) {
        showPopupMenuItem(items, binding.textViewDirection) { viewModel.onMenuItemClick(it) }
    }
}