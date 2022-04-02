package com.app.rapidnumberconverter.ui.common

import android.view.Gravity
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.app.rapidnumberconverter.R
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(view: View, text: String) {
    val snackBar = Snackbar.make(
        view,
        text,
        Snackbar.LENGTH_INDEFINITE
    )
    snackBar.setAction("Got it") {
        snackBar.dismiss()
    }
    val layoutParams = snackBar.view.layoutParams as CoordinatorLayout.LayoutParams
    layoutParams.anchorId = R.id.nav_view
    layoutParams.anchorGravity = Gravity.TOP
    layoutParams.gravity = Gravity.TOP
    layoutParams.gravity = Gravity.TOP
    snackBar.view.layoutParams = layoutParams
    snackBar.show()
}