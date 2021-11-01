package com.app.rapidnumberconverter.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.StringBuilder
import java.util.stream.Collectors

fun String.toBinary() : String{
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
fun String.prettyBinary(blockSize : Int, separator : String ) : String{

    val result: MutableList<String> = ArrayList()
    var index = 0
    while (index < this.length) {
        result.add(this.substring(index, Math.min(index + blockSize, this.length )))
        index += blockSize
    }
    return result.stream().collect(Collectors.joining(separator))
}