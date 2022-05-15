package com.app.rapidnumberconverter.bindings

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("showOrHide")
fun showOrHide(view: View, shouldShow: Boolean) {
    if (shouldShow) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("htmlText")
fun setHtmlText(textView: TextView, text: String?) {
    text?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.text = Html.fromHtml(it, 0)
        } else {
            textView.text = Html.fromHtml(it)
        }
    }
}