package com.app.rapidnumberconverter.utils

object BinaryConverters {

    fun toDecimal(value: String) = Integer.parseInt(value, 2).toString()

    fun toOctal(value: String): String {
        val decimalValue = value.toInt(2)
        return Integer.toOctalString(decimalValue)
    }

    fun toHexadecimal(value: String): String {
        val decimalValue = value.toInt(2)
        return Integer.toHexString(decimalValue)
    }
}