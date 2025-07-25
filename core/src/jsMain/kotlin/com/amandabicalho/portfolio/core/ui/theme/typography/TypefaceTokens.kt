package com.amandabicalho.portfolio.core.ui.theme.typography

import com.varabyte.kobweb.compose.css.FontWeight

val Roboto = FontFamily(
    Font("Roboto", "sans-serif"),
)

internal object TypefaceTokens {
    val Brand = Roboto
    val Plain = Roboto
    val WeightBold = FontWeight.Bold
    val WeightMedium = FontWeight.Medium
    val WeightRegular = FontWeight.Normal
}
