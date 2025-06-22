package com.amandabicalho.portfolio.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.silk.theme.colors.palette.Palette

data class Elevation(
    val shadows: List<BoxShadow> = listOf()
) {
    companion object {
        operator fun invoke(vararg shadows: BoxShadow) = Elevation(shadows.toList())
    }
}

class Elevations(
    val level0: Elevation = Elevation(),
    val level1: Elevation = Elevation(),
    val level2: Elevation = Elevation(),
    val level3: Elevation = Elevation(),
    val level4: Elevation = Elevation(),
    val level5: Elevation = Elevation(),
) : Palette {
    infix fun to(other: Elevations) = ThemedValue(light = this, dark = other)
    override fun get(key: String): Color? = when (key) {
        else -> null
    }
}

internal val LocalElevations = staticCompositionLocalOf { Elevations() }
