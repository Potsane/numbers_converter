package com.app.rapidnumberconverter.ui.about

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentAboutBinding
import com.app.rapidnumberconverter.ui.base.BaseRapidNumbersFragment

class AboutFragment : BaseRapidNumbersFragment<AboutViewModel, FragmentAboutBinding>() {

    override fun getLayoutId() = R.layout.fragment_about

    override fun createViewModel(): AboutViewModel {
        return ViewModelProvider(this, AboutViewModel.Factory())[AboutViewModel::class.java]
    }

    override fun onUiCommands(command: Any) {
        when (command) {
            is LaunchExternalPage -> openWebPage(command.url)
            is ShareApp ->  shareText(command.title, command.body)
            else -> super.onUiCommands(command)
        }
    }

    private fun openWebPage(url: String?) {
        val browse = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browse)
    }

    private fun shareText(subject: String?, body: String?) {
        val txtIntent = Intent(Intent.ACTION_SEND)
        txtIntent.type = "text/plain"
        txtIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        txtIntent.putExtra(Intent.EXTRA_TEXT, body)
        startActivity(Intent.createChooser(txtIntent, "Share"))
    }

}