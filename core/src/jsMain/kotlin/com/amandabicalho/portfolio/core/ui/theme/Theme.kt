package com.amandabicalho.portfolio.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.amandabicalho.portfolio.core.ui.theme.color.ColorScheme
import com.amandabicalho.portfolio.core.ui.theme.color.LocalColorScheme
import com.amandabicalho.portfolio.core.ui.theme.typography.LocalTypography
import com.amandabicalho.portfolio.core.ui.theme.typography.Typography
import com.varabyte.kobweb.compose.KobwebComposeStyles
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.KobwebApp
import com.varabyte.kobweb.silk.ColorModeAware
import com.varabyte.kobweb.silk.SilkFoundationStyles
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.breakpoint.BreakpointValues
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.Palette
import com.varabyte.kobweb.silk.theme.colors.palette.Palettes
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit

private const val COLOR_MODE_KEY = "portfolio:colorMode"

data class ThemedValue<out T : Palette>(
    override val light: T,
    override val dark: T,
) : Palettes

@InitSilk
fun initCssColorScheme(context: InitSilkContext) =
    context.stylesheet.apply {
        registerStyle("[data-theme=\"light\"]") {
            base {
                Modifier.styleModifier {
                    property("color-scheme", "light")
                }
            }
        }
        registerStyle("[data-theme=\"dark\"]") {
            base {
                Modifier.styleModifier {
                    property("color-scheme", "dark")
                }
            }
        }
    }

@InitSilk
fun initColorMode(context: InitSilkContext) {
    context.config.initialColorMode = localStorage
        .getItem(COLOR_MODE_KEY)
        ?.let(ColorMode::valueOf)
        ?: if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
            ColorMode.DARK
        } else {
            ColorMode.LIGHT
        }
}

@Composable
fun Theme(
    themedColorScheme: ThemedValue<ColorScheme>,
    typography: Typography,
    themedElevations: ThemedValue<Elevations>,
    breakpoints: BreakpointValues<CSSSizeValue<CSSUnit.rem>>,
    content: @Composable (colorMode: ColorMode) -> Unit,
) {
    KobwebApp {
        KobwebComposeStyles()
        SilkFoundationStyles()
        ColorModeAware()
        val colorMode by ColorMode.currentState
        LaunchedEffect(colorMode) {
            localStorage.setItem(COLOR_MODE_KEY, colorMode.name)
            document
                .documentElement
                ?.setAttribute("data-theme", colorMode.name.lowercase())
        }

        val (colorScheme, elevations) = when (colorMode) {
            ColorMode.LIGHT -> themedColorScheme.light to themedElevations.light
            ColorMode.DARK -> themedColorScheme.dark to themedElevations.dark
        }

        CompositionLocalProvider(
            LocalColorScheme provides colorScheme,
            LocalTypography provides typography,
            LocalElevations provides elevations,
            LocalBreakpointValues provides breakpoints,
        ) {
            content(colorMode)
        }
    }
}

@Composable
private fun InitSilkWidgetVariables() {
    val root = remember { document.body }
    root?.let { ColorModeAware(it) }
}

object Theme {
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val elevations: Elevations
        @Composable
        @ReadOnlyComposable
        get() = LocalElevations.current

    val breakpoints: BreakpointValues<CSSSizeValue<CSSUnit.rem>>
        @Composable
        @ReadOnlyComposable
        get() = LocalBreakpointValues.current
}

internal val LocalBreakpointValues = staticCompositionLocalOf<BreakpointValues<CSSSizeValue<CSSUnit.rem>>> {
    error("No breakpoint values provided")
}
