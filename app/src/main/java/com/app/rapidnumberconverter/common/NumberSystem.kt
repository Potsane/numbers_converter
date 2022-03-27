package com.app.rapidnumberconverter.common

enum class NumberSystem(value: String) {
    DECIMAL("Decimal"),
    HEXADECIMAL("Hexadecimal"),
    OCTAL("Octal"),
    BINARY("Binary");

    companion object {
        fun getEnumForValue(value: String): NumberSystem {
            return when(value){
                "Decimal" -> DECIMAL
                "Hexadecimal" -> HEXADECIMAL
                "Octal" -> OCTAL
                "Binary" -> BINARY
                else -> DECIMAL
            }
        }
    }
}