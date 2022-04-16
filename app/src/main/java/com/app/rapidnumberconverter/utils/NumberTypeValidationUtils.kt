package com.app.rapidnumberconverter.utils

import com.app.rapidnumberconverter.common.NumberSystem

fun isValidNumberInput(value: String?, fromNumberSystem: NumberSystem): Boolean {
    val typeRadix = when (fromNumberSystem) {
        NumberSystem.BINARY -> 2
        NumberSystem.OCTAL -> 8
        NumberSystem.DECIMAL -> 10
        NumberSystem.HEXADECIMAL -> 16
    }

    if (value.isNullOrEmpty()) return false
    return try {
        value.toBigInteger(typeRadix)
        true
    } catch (ex: Exception) {
        false
    }
}