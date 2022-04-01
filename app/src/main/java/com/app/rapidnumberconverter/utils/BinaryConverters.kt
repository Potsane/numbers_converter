package com.app.rapidnumberconverter.utils

import kotlin.math.pow

object BinaryConverters {

    fun toDecimal(value: String) = Integer.parseInt(value, 2).toString()

    fun toOctal(value: String): String {
        var binaryNumber = value.toLong()
        var octalNumber = 0
        var decimalNumber = 0
        var i = 0
        while (binaryNumber != 0L) {
            decimalNumber += (binaryNumber % 10 * 2.0.pow(i.toDouble())).toInt()
            ++i
            binaryNumber /= 10
        }
        i = 1
        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * i
            decimalNumber /= 8
            i *= 10
        }
        return octalNumber.toString()
    }

    fun toHexadecimal(value: String): String {
        var binNumber = value.toInt()
        var rem: Int
        var hexdecnum = ""

        val hex =
            charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

        while (binNumber > 0) {
            rem = binNumber % 16
            hexdecnum = hex[rem].toString() + hexdecnum
            binNumber /= 16
        }
        return (hexdecnum)
    }
}