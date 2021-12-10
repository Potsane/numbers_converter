package com.app.rapidnumberconverter.common

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.app.rapidnumberconverter.R
import com.app.rapidnumberconverter.databinding.LayoutKeyboardBinding

class Keyboard(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var button1: Button? = null
    private var inputConnection: InputConnection? = null
    private lateinit var binding : LayoutKeyboardBinding

    init {
        initKeyboard(context, attrs)
    }

    fun setInputConnection(inputConnection: InputConnection?) {
        this.inputConnection = inputConnection
    }

    constructor(context: Context?) : this(context, null, 0) {}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {}

    private fun initKeyboard(context: Context?, attrs: AttributeSet?) {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_keyboard,
            null,
            false
        )
        addView(
            binding.root
        )

        button1 =binding.buttonA
        button1!!.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        if (inputConnection == null) return
        /*if (view.getId() === R.id.button_delete) {
            val selectedText = inputConnection!!.getSelectedText(0)
            if (TextUtils.isEmpty(selectedText)) {
                inputConnection!!.deleteSurroundingText(1, 0)
            } else {
                inputConnection!!.commitText("", 1)
            }
        } else {
            val value = keyValues[view.getId()]
            inputConnection!!.commitText(value, 1)
        }*/
        inputConnection!!.commitText("1", 1)
    }
}