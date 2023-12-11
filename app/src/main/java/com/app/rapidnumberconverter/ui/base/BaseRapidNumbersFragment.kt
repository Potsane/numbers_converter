package com.app.rapidnumberconverter.ui.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.rapidnumberconverter.navigation.NavigationCommand
import com.app.rapidnumberconverter.ui.about.LaunchExternalPage
import com.app.rapidnumberconverter.ui.translation.ShowTranslationResult
import com.app.rapidnumberconverter.ui.translation.TranslationResultDialogFragment

abstract class BaseRapidNumbersFragment<VM : BaseRapidNumbersViewModel> :
    Fragment() {

    protected val viewModel by lazy { createViewModel() }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent()
        }
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiCommands.observe(viewLifecycleOwner, Observer(::onUiCommands))
        viewModel.navigationCommands.observe(viewLifecycleOwner, Observer(::onNavigate))
    }

    private fun onNavigate(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.ToDirection -> findNavController().navigate(navigationCommand.directions)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

    @CallSuper
    protected open fun onUiCommands(command: Any) {
        when (command) {
            is HideKeyboard -> hideKeyBoard()
            is ShowProgress -> showProgressBar(command.show)
            is LaunchExternalPage -> openWebPage(command.url)
            is ShowTranslationResult -> showTranslationResultDialog(command.title, command.text)
        }
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        showProgressBar(false)
    }

    protected abstract fun createViewModel(): VM

    protected abstract fun ComposeView.setContent()

    protected fun hideKeyBoard() {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        val view = activity?.currentFocus ?: this.view
        view?.let { inputMethodManager?.hideSoftInputFromWindow(it.windowToken, 0) }
    }

    private fun showTranslationResultDialog(title: String?, text: String) {
        val bottomSheetFragment = TranslationResultDialogFragment.newInstance(text, title)
        bottomSheetFragment.show(parentFragmentManager, null)
    }

    private fun showProgressBar(show: Boolean) =
        (requireActivity() as MainActivity).showProgressBar(show)

    private fun openWebPage(url: String?) {
        val browse = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browse)
    }
}