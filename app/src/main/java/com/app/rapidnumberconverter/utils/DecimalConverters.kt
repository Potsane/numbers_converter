package com.app.rapidnumberconverter.utils

object DecimalConverters {
    fun convertToBinary(value : Int): String = Integer.toBinaryString(value)
    fun convertDecimalToOctal(value : Int): String = Integer.toOctalString(value)
    fun convertDecimalToHexadecimal(value : Int): String = Integer.toHexString(value)
}