package com.app.rapidnumberconverter.common

enum class TranslationDirection {
    TEXT_TO_BINARY,
    BINARY_TO_TEXT;

    companion object {
        fun getEnumForValue(value: String): TranslationDirection {
            return when(value){
                "Text to Binary" -> TEXT_TO_BINARY
                else -> BINARY_TO_TEXT
            }
        }
    }
}