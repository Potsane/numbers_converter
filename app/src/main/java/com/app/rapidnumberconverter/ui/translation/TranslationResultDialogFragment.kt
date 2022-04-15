package com.app.rapidnumberconverter.ui.translation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.app.rapidnumberconverter.BR
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.FragmentTranslationResultDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TranslationResultDialogFragment : BottomSheetDialogFragment(), TranslationResultListener {

    private lateinit var binding: FragmentTranslationResultDialogBinding
    private val translatedText by lazy { requireArguments().getString(TRANSLATED_TEXT) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_translation_result_dialog,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewTranslatedText.text = translatedText
        binding.setVariable(BR.listener, this)
    }

    override fun onCopyText() {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE)
                as ClipboardManager?
        val clip = ClipData.newPlainText("result", translatedText)
        clipboard?.setPrimaryClip(clip)

        dismiss()
    }

    companion object {

        private const val TRANSLATED_TEXT = "translated_text"

        fun newInstance(translatedText: String) = TranslationResultDialogFragment().apply {
            arguments = Bundle().apply {
                putString(TRANSLATED_TEXT, translatedText)
            }
        }
    }
}