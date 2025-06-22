package com.amandabicalho.portfolio

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Elevation
import com.amandabicalho.portfolio.core.ui.theme.Elevations
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.color.copy
import com.amandabicalho.portfolio.core.ui.theme.color.from
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.ui.theme.DarkColorScheme
import com.amandabicalho.portfolio.ui.theme.LightColorScheme
import com.amandabicalho.portfolio.ui.theme.Typography
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.breakpoint.BreakpointSizes

private val ElevationsLight = Elevations(
    level1 = Elevation(
        BoxShadow.of(
            offsetX = 0.dp,
            offsetY = 1.dp,
            blurRadius = 3.dp,
            spreadRadius = 1.dp,
            color = Colors.Black.copy(alpha = 0.15f),
        ),
        BoxShadow.of(
            offsetX = 0.dp,
            offsetY = 1.dp,
            blurRadius = 2.dp,
            spreadRadius = 0.dp,
            color = Colors.Black.copy(alpha = 0.3f),
        )
    ),
)

private val ElevationsDark = Elevations(
    level1 = Elevation(
        BoxShadow.of(
            offsetX = 0.dp,
            offsetY = 4.dp,
            blurRadius = 4.dp,
            spreadRadius = 0.dp,
            color = Colors.Black.copy(alpha = 0.30f),
        ),
        BoxShadow.of(
            offsetX = 0.dp,
            offsetY = 8.dp,
            blurRadius = 12.dp,
            spreadRadius = 6.dp,
            color = Colors.Black.copy(alpha = 0.15f),
        ),
    ),
)

private val Breakpoints = BreakpointSizes(
    sm = 320.dp,
    md = 768.dp,
    lg = 1024.dp,
    xl = 1300.dp,
)

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.from(LightColorScheme)
    ctx.theme.palettes.dark.from(DarkColorScheme)
}

@Composable
fun Theme(
    content: @Composable () -> Unit,
) {
    Theme(
        themedColorScheme = LightColorScheme to DarkColorScheme,
        typography = Typography,
        breakpoints = Breakpoints,
        themedElevations = ElevationsLight to ElevationsDark,
    ) {
        content()
    }
}
