package com.amandabicalho.portfolio.core.ui.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.amandabicalho.portfolio.core.ui.theme.ThemedValue
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.theme.colors.palette.MutablePalette
import com.varabyte.kobweb.silk.theme.colors.palette.Palette
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

@Immutable
data class ColorScheme(
    val primary: ColorShades,
    val text: Color,
    val background: Color,
    val gray: Color,
    val white: Color,
) : Palette {
    infix fun to(other: ColorScheme) = ThemedValue(light = this, dark = other)

    override fun get(key: String): Color? = when (key) {
        ::primary.name -> primary.shade10
        ::text.name -> text
        ::background.name -> background
        ::gray.name -> gray
        ::white.name -> white
        else -> null
    }
}

fun MutablePalette.from(colorScheme: ColorScheme) {
    background = colorScheme.background
    color = colorScheme.text
}

data class ColorShades(
    val shade10: Color,
    val shade20: Color,
    val shade30: Color,
    val shade50: Color,
) {
    operator fun get(index: Int): Color = when (index) {
        10 -> shade10
        20 -> shade20
        30 -> shade30
        50 -> shade50
        else -> throw IllegalArgumentException("Invalid color shade index: $index")
    }
}

internal val LocalColorScheme = staticCompositionLocalOf<ColorScheme> { error("not provided color scheme.") }
