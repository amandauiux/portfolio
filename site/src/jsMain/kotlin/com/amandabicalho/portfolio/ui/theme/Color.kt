package com.amandabicalho.portfolio.ui.theme

import com.amandabicalho.portfolio.core.ui.theme.color.ColorScheme
import com.amandabicalho.portfolio.core.ui.theme.color.ColorShades
import com.varabyte.kobweb.compose.ui.graphics.Color

internal val LightColorScheme = ColorScheme(
    primary = ColorShades(
        shade10 = Color.argb(0xFFD9480F),
        shade20 = Color.argb(0xFFBE3F0D),
        shade30 = Color.argb(0xFFA3360B),
        shade50 = Color.argb(0xFF882D09),
    ),
    text = Color.argb(0xFF1B0902),
    background = Color.argb(0xFFFFFCF7),
    gray = Color.argb(0xFFE5E4E4),
    white = Color.argb(0xFFE5E4E4),
)

internal val DarkColorScheme = LightColorScheme
