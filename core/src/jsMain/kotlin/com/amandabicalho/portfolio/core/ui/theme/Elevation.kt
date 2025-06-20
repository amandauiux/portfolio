package com.amandabicalho.portfolio.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.varabyte.kobweb.compose.css.BoxShadow

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
) {
    infix fun to(other: Elevations) = ThemedValue(light = this, dark = other)
}

internal val LocalElevations = staticCompositionLocalOf { Elevations() }
