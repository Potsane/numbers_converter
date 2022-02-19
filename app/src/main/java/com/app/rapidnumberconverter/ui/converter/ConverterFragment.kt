package com.app.rapidnumberconverter.ui.converter

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentConverterBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.base.MainActivity

class ConverterFragment : BaseRapidNumbersFragment<ConverterViewModel, FragmentConverterBinding>() {

    private val numberSystemsMenuWindow by lazy {
        ListPopupWindow(requireContext(), null, R.attr.listPopupWindowStyle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        numberSystemsMenuWindow.anchorView = binding.textViewFrom
        val items = viewModel.numberSystems
        val adapter =
            ArrayAdapter(activity as MainActivity, R.layout.view_number_system_item, items)
        numberSystemsMenuWindow.setAdapter(adapter)
        numberSystemsMenuWindow.setOnItemClickListener(viewModel)
    }

    override fun getLayoutId() = R.layout.fragment_converter

    override fun onUiCommands(event: Any) {
        if (event is ShowNumbersMenu) {
            numberSystemsMenuWindow.show()
        } else super.onUiCommands(event)
    }

    override fun createViewModel(): ConverterViewModel {
        return ViewModelProvider(this, ConverterViewModel.Factory())
            .get(ConverterViewModel::class.java)
    }
}