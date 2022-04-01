package com.app.rapidnumberconverter.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.app.rapidnumberconverter.common.NumberSystem
import java.lang.StringBuilder
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
        NumberSystem.OCTAL -> BinaryConverters.toOctal(value)
        NumberSystem.DECIMAL -> BinaryConverters.toDecimal(value)
        NumberSystem.HEXADECIMAL -> BinaryConverters.toHexadecimal(value)
        else -> null
    }
}

fun convertDecimal(convertTo: NumberSystem, value: Int): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> DecimalConverters.convertToBinary(value)
        NumberSystem.OCTAL -> DecimalConverters.convertDecimalToOctal(value)
        NumberSystem.HEXADECIMAL -> DecimalConverters.convertDecimalToHexadecimal(value)
        else -> null
    }
}

fun convertOctal(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> OctalConverters.toBinary(value)
        NumberSystem.DECIMAL -> OctalConverters.toDecimal(value)
        NumberSystem.HEXADECIMAL -> OctalConverters.toHexadecimal(value)
        else -> null
    }
}

fun convertHexadecimal(convertTo: NumberSystem, value: String): String? {
    return when (convertTo) {
        NumberSystem.BINARY -> HexadecimalConverters.toBinary(value)
        NumberSystem.OCTAL -> HexadecimalConverters.toOctal(value)
        NumberSystem.DECIMAL -> HexadecimalConverters.toDecimal(value)
        else -> null
    }
}