package com.app.rapidnumberconverter.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.app.rapidnumberconverter.common.NumberSystem
import java.math.BigInteger
import java.util.stream.Collectors

fun String.toBinary(): String {
    val result = StringBuilder()
    val chars: CharArray = this.toCharArray()
    for (aChar in chars) {
        result.append(
            String.format("%8s", Integer.toBinaryString(aChar.toInt()))
                .replace(" ".toRegex(), "0")
        )
    }
    return result.toString()
}

@RequiresApi(Build.VERSION_CODES.N)
fun String.prettyBinary(blockSize: Int, separator: String): String {

    val result: MutableList<String> = ArrayList()
    var index = 0
    while (index < this.length) {
        result.add(this.substring(index, (index + blockSize).coerceAtMost(this.length)))
        index += blockSize
    }
    return result.stream().collect(Collectors.joining(separator))
}

fun convertBinary(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.OCTAL -> BigInteger(value, 2).toString(8)
        NumberSystem.DECIMAL -> BigInteger(value, 2).toString(10)
        NumberSystem.HEXADECIMAL -> BigInteger(value, 2).toString(16)
        else -> null
    }
}

fun convertDecimal(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> BigInteger(value).toString(2)
        NumberSystem.OCTAL -> BigInteger(value).toString(8)
        NumberSystem.HEXADECIMAL -> BigInteger(value).toString(16)
        else -> null
    }
}

fun convertOctal(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> BigInteger(value, 8).toString(2)
        NumberSystem.DECIMAL -> BigInteger(value, 8).toString(10)
        NumberSystem.HEXADECIMAL -> BigInteger(value, 8).toString(16)
        else -> null
    }
}

fun convertHexadecimal(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> BigInteger(value, 16).toString(2)
        NumberSystem.OCTAL -> BigInteger(value, 16).toString(8)
        NumberSystem.DECIMAL -> BigInteger(value, 16).toString(10)
        else -> null
    }
}