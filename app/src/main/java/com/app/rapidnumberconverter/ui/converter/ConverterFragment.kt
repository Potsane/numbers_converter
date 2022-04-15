package com.app.rapidnumberconverter.ui.converter

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.databinding.FragmentConverterBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.common.showDialog

class ConverterFragment : BaseRapidNumbersFragment<ConverterViewModel, FragmentConverterBinding>() {

    override fun getLayoutId() = R.layout.fragment_converter

    override fun onUiCommands(command: Any) {
        when (command) {
            is ShowFromNumbersMenu -> showNumbersMenuItem(command)
            is ShowInvalidNumberFormatDialog -> showInvalidNumberFormatDialog()
            else -> super.onUiCommands(command)
        }
    }

    override fun createViewModel(): ConverterViewModel {
        return ViewModelProvider(
            this,
            ConverterViewModel.Factory()
        )[ConverterViewModel::class.java]
    }

    private fun showNumbersMenuItem(command: ShowFromNumbersMenu) {
        showPopupMenuItem(
            command.menuItems,
            getAnchorView(command)
        ) { viewModel.onMenuItemClick(it, command .conversionContext) }
    }

    private fun showInvalidNumberFormatDialog() {
        hideKeyBoard()
        showDialog(
            dialogTitle = "Number format",
            dialogMessage = "Ensure the number is in the correct format",
            context = requireContext()
        )
    }

    private fun getAnchorView(command: ShowFromNumbersMenu): View {
        return if (command.conversionContext == ConversionContext.CONVERT_FROM) binding.textViewFrom
        else binding.textViewTo
    }
}