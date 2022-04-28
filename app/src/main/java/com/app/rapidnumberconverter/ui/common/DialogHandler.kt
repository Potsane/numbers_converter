package com.app.rapidnumberconverter.ui.common

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

fun showDialog(
    dialogTitle: String,
    dialogMessage: String,
    dialogPositiveButtonText: String? = "Got it",
    context: Context,
    onClickListener: DialogInterface.OnClickListener? = null
) {
    val dialog = AlertDialog.Builder(context)
        .setTitle(dialogTitle)
        .setMessage(dialogMessage)
        .setNegativeButton("Cancel", null)
        .setPositiveButton(dialogPositiveButtonText, onClickListener)
        .create()
    dialog.show()
}