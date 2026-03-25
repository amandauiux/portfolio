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
    black = Color.argb(0xFF141414),
)

internal val DarkColorScheme = ColorScheme(
    primary = ColorShades(
        shade10 = Color.argb(0xFFF0895F),
        shade20 = Color.argb(0xFFE97546),
        shade30 = Color.argb(0xFFE15F2D),
        shade50 = Color.argb(0xFFD9480F),
    ),
    text = Color.argb(0xFFF5EDE6),
    background = Color.argb(0xFF171010),
    gray = Color.argb(0xFF5B5656),
    white = Color.argb(0xFF5B5656),
    black = Color.argb(0xFFF5EDE6),
)
