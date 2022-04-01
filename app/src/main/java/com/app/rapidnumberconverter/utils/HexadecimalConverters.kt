package com.app.rapidnumberconverter.utils


object HexadecimalConverters {

    fun toDecimal(value: String) = Integer.parseInt(value, 16).toString()

    fun toBinary(value: String): String {
        val decimal: Int = value.toInt(16)
        return Integer.toBinaryString(decimal)
    }

    fun toOctal(value: String): String {
        val decimal: Int = value.toInt(16)
        return Integer.toOctalString(decimal)
    }
}