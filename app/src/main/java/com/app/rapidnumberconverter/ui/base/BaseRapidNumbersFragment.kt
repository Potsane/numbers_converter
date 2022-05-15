package com.app.rapidnumberconverter.ui.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.app.rapidnumberconverter.BR
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.ui.about.LaunchExternalPage
import com.app.rapidnumberconverter.ui.translation.ShowTranslationResult
import com.app.rapidnumberconverter.ui.translation.TranslationResultDialogFragment

abstract class BaseRapidNumbersFragment<VM : BaseRapidNumbersViewModel, VDB : ViewDataBinding> :
    Fragment() {

    protected lateinit var binding: VDB

    protected val viewModel by lazy { createViewModel() }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        )
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        viewModel.uiCommands.observe(viewLifecycleOwner, Observer(::onUiCommands))
    }

    @CallSuper
    protected open fun onUiCommands(command: Any) {
        when (command) {
            is HideKeyboard -> hideKeyBoard()
            is ShowProgress -> showProgressBar(command.show)
            is LaunchExternalPage -> openWebPage(command.url)
            is ShowTranslationResult -> showTranslationResultDialog(command.text)
        }
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        showProgressBar(false)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun createViewModel(): VM

    protected fun hideKeyBoard() {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        val view = activity?.currentFocus ?: this.view
        view?.let { inputMethodManager?.hideSoftInputFromWindow(it.windowToken, 0) }
    }

    private fun showTranslationResultDialog(text: String) {
        val bottomSheetFragment = TranslationResultDialogFragment.newInstance(text)
        bottomSheetFragment.show(parentFragmentManager, null)
    }

    protected fun showPopupMenuItem(
        items: List<String>,
        anchorView: View,
        onItemCLicked: (String) -> Unit
    ) {
        val numberSystemsMenuWindow =
            ListPopupWindow(requireContext(), null, R.attr.listPopupWindowStyle)

        val adapter = getMenuItemsAdapter(items)
        numberSystemsMenuWindow.anchorView = anchorView
        numberSystemsMenuWindow.setAdapter(adapter)
        numberSystemsMenuWindow.setOnItemClickListener { _, _, position, _ ->
            numberSystemsMenuWindow.dismiss()
            onItemCLicked(items[position])
        }
        numberSystemsMenuWindow.show()
    }

    private fun getMenuItemsAdapter(items: List<String>): ArrayAdapter<String> {
        return ArrayAdapter(
            activity as MainActivity,
            R.layout.view_popup_menu_item,
            items
        )
    }

    private fun showProgressBar(show: Boolean) =
        (requireActivity() as MainActivity).showProgressBar(show)

    private fun openWebPage(url: String?) {
        val browse = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browse)
    }

}