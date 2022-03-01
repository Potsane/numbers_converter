package com.app.rapidnumberconverter.ui.converter

import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.common.ConversionContext
import com.app.rapidnumberconverter.databinding.FragmentConverterBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.base.MainActivity

class ConverterFragment : BaseRapidNumbersFragment<ConverterViewModel, FragmentConverterBinding>() {

    private val numberSystemsMenuWindow by lazy {
        ListPopupWindow(requireContext(), null, R.attr.listPopupWindowStyle)
    }

    override fun getLayoutId() = R.layout.fragment_converter

    override fun onUiCommands(event: Any) {
        if (event is ShowFromNumbersMenu) {
            showNumbersMenuItem(event)
        } else super.onUiCommands(event)
    }

    override fun createViewModel(): ConverterViewModel {
        return ViewModelProvider(this, ConverterViewModel.Factory())
            .get(ConverterViewModel::class.java)
    }

    private fun showNumbersMenuItem(event: ShowFromNumbersMenu) {
        val adapter = getMenuItemsAdapter(event)
        numberSystemsMenuWindow.anchorView = getAnchorView(event)
        numberSystemsMenuWindow.setAdapter(adapter)
        numberSystemsMenuWindow.setOnItemClickListener { _, _, position, _ ->
            numberSystemsMenuWindow.dismiss()
            viewModel.onMenuItemClick(event.menuItems[position], event.conversionContext)
        }
        numberSystemsMenuWindow.show()
    }

    private fun getMenuItemsAdapter(event: ShowFromNumbersMenu): ArrayAdapter<String> {
        return ArrayAdapter(
            activity as MainActivity,
            R.layout.view_number_system_item,
            event.menuItems
        )
    }

    private fun getAnchorView(event: ShowFromNumbersMenu): View {
        return if (event.conversionContext == ConversionContext.CONVERT_FROM) binding.textViewFrom
        else binding.textViewTo
    }
}