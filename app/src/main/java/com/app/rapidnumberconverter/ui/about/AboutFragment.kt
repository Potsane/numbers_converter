package com.app.rapidnumberconverter.ui.about

import android.content.Intent
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment
import com.app.rapidnumberconverter.ui.theme.NumbersConverterAppTheme

class AboutFragment : BaseRapidNumbersFragment<AboutViewModel>() {

    override fun createViewModel(): AboutViewModel {
        return ViewModelProvider(this, AboutViewModel.Factory())[AboutViewModel::class.java]
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is ShareApp -> shareText(command.title, command.body)
            else -> super.onUiCommands(command)
        }
    }

    private fun shareText(subject: String?, body: String?) {
        val txtIntent = Intent(Intent.ACTION_SEND)
        txtIntent.type = "text/plain"
        txtIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        txtIntent.putExtra(Intent.EXTRA_TEXT, body)
        startActivity(Intent.createChooser(txtIntent, "Share"))
    }

    override fun ComposeView.setContent() = setContent {
        NumbersConverterAppTheme {
            AboutScreen {
                viewModel.onCardClick(it)
            }
        }
    }
}