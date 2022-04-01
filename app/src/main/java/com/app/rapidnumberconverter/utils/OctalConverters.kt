package com.app.rapidnumberconverter.utils

object OctalConverters {

    fun toDecimal(value: String) = Integer.parseInt(value, 8).toString()

    fun toBinary(value: String): String {
        val decimalValue = Integer.parseInt(value, 8)
        return Integer.toBinaryString(decimalValue)
    }

    fun toHexadecimal(value: String): String {
        val decimalValue = Integer.parseInt(value, 8)
        return Integer.toHexString(decimalValue)
    }
}