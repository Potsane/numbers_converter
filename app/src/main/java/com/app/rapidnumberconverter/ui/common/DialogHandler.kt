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
    val builder = AlertDialog.Builder(context)
    builder.setMessage(dialogMessage)
        .setTitle(dialogTitle)
    builder.setNegativeButton("Cancel", null)
    builder.setPositiveButton(dialogPositiveButtonText, onClickListener)

    val dialog: AlertDialog = builder.create()
    dialog.show()
}