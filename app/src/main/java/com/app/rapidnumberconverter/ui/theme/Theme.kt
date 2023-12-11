package com.app.rapidnumberconverter.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = GreenA700,
    background = White100,
    secondaryContainer  = Grey150
)

@Composable
fun NumbersConverterAppTheme(content: @Composable () -> Unit) {
    val colorScheme = LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}