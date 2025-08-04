package com.amandabicalho.portfolio.core.designsystem.components.atom.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.ButtonDefaults.Vars
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.amandabicalho.portfolio.core.ui.theme.Elevation
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.color.Unspecified
import com.amandabicalho.portfolio.core.ui.theme.color.copy
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.css.VerticalAlign
import com.varabyte.kobweb.compose.css.boxShadow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.modifiers.verticalAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.hover

typealias ButtonVariant = CssStyleVariant<ButtonKind>

sealed interface ButtonKind : ComponentKind

val ButtonStyle = CssStyle<ButtonKind> {
    base {
        Modifier
            .backgroundColor(Vars.ContainerColor.value())
            .color(Vars.ContentColor.value())
            .styleModifier {
                boxShadow(Vars.DefaultElevation.value())
            }
            .verticalAlign(VerticalAlign.Middle)
            .borderRadius(Vars.BorderRadius.value())
            .border { width(0.dp) }
            .cursor(Vars.Cursor.value())
            .userSelect(UserSelect.None) // No selecting text within buttons
            .transition(Transition.of("background-color", duration = ButtonVars.ColorTransitionDuration.value()))
    }

    hover {
        Modifier
            .styleModifier {
                boxShadow(Vars.HoveredElevation.value())
            }
    }

    focus {
        Modifier
            .styleModifier {
                boxShadow(Vars.FocusedElevation.value())
            }
    }

    active {
        Modifier
            .styleModifier {
                boxShadow(Vars.PressedElevation.value())
            }
    }

    cssRule(":disabled") {
        Modifier
            .backgroundColor(Vars.DisabledContainerColor.value())
            .color(Vars.DisabledContentColor.value())
            .styleModifier {
                boxShadow(Vars.DisabledElevation.value())
            }
    }
}

object ButtonDefaults {
    object Vars {
        val ContainerColor by StyleVariable<Color>("button")
        val ContentColor by StyleVariable<Color>("button")
        val BorderColor by StyleVariable<Color>("button")
        val DisabledContainerColor by StyleVariable<Color>("button")
        val DisabledContentColor by StyleVariable<Color>("button")
        val DisabledBorderColor by StyleVariable<Color>("button")
        val HoverContainerColor by StyleVariable<Color>("button")
        val HoverContentColor by StyleVariable<Color>("button")
        val HoverBorderColor by StyleVariable<Color>("button")
        val DefaultElevation by StyleVariable<String>("button")
        val PressedElevation by StyleVariable<String>("button")
        val FocusedElevation by StyleVariable<String>("button")
        val HoveredElevation by StyleVariable<String>("button")
        val DisabledElevation by StyleVariable<String>("button")
        val BorderRadius by StyleVariable<Dp>("button")
        val Cursor by StyleVariable<Cursor>("button")
    }

    val ContentPadding = PaddingValues(
        start = 24.dp,
        top = 8.dp,
        end = 24.dp,
        bottom = 8.dp
    )

    val TextButtonContentPadding = PaddingValues(
        vertical = 10.dp,
        horizontal = 24.dp,
    )

    val IconButtonContentPadding = PaddingValues(all = 4.dp)

    val BorderRadius = 100.dp

    @Composable
    fun buttonColors(
        containerColor: Color = Color.Unspecified,
        contentColor: Color = Color.Unspecified,
        disabledContainerColor: Color = Color.Unspecified,
        disabledContentColor: Color = Color.Unspecified,
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
    )

    @Composable
    fun textButtonColors(
        contentColor: Color = Theme.colorScheme.text,
        disabledContentColor: Color = Theme.colorScheme.text.copy(alpha = 0.5f),
        hoveredContainerColor: Color = Theme.colorScheme.text.copy(alpha = 0.1f),
    ): ButtonColors = ButtonColors(
        containerColor = hoveredContainerColor,
        contentColor = contentColor,
        disabledContainerColor = Colors.Transparent,
        disabledContentColor = disabledContentColor,
    )

    @Composable
    fun iconButtonColors(
        contentColor: Color = Theme.colorScheme.text,
        disabledContentColor: Color = Theme.colorScheme.text.copy(alpha = 0.5f),
        hoveredContainerColor: Color = Theme.colorScheme.text.copy(alpha = 0.1f),
    ): ButtonColors = ButtonColors(
        containerColor = hoveredContainerColor,
        contentColor = contentColor,
        disabledContainerColor = Colors.Transparent,
        disabledContentColor = disabledContentColor,
    )

    @Composable
    fun outlinedButtonColors(
        containerColor: Color = Colors.Transparent,
        contentColor: Color = Theme.colorScheme.primary[50],
        borderColor: Color = Theme.colorScheme.primary[50],
        disabledContainerColor: Color = Colors.Transparent,
        disabledContentColor: Color = contentColor.copy(alpha = 0.5f),
        disabledBorderColor: Color = Theme.colorScheme.primary[50].copy(alpha = 0.5f),
        hoverContainerColor: Color = Theme.colorScheme.primary[20],
        hoverContentColor: Color = Theme.colorScheme.white,
        hoverBorderColor: Color = Theme.colorScheme.text,
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = borderColor,
        borderColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
        disabledBorderColor = disabledBorderColor,
        hoverContainerColor = hoverContainerColor,
        hoverContentColor = hoverContentColor,
        hoverBorderColor = hoverBorderColor,
    )

    @Composable
    fun buttonElevation(
        defaultElevation: Elevation = Theme.elevations.level0,
        pressedElevation: Elevation = Theme.elevations.level0,
        focusedElevation: Elevation = Theme.elevations.level0,
        hoveredElevation: Elevation = Theme.elevations.level1,
        disabledElevation: Elevation = Theme.elevations.level0,
    ): ButtonElevation = ButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation,
    )
}

@Immutable
@ConsistentCopyVisibility
data class ButtonColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val borderColor: Color = Color.Unspecified,
    private val disabledContainerColor: Color,
    private val disabledContentColor: Color,
    private val disabledBorderColor: Color = Color.Unspecified,
    private val hoverContainerColor: Color = Color.Unspecified,
    private val hoverContentColor: Color = Color.Unspecified,
    private val hoverBorderColor: Color = Color.Unspecified,
) {
    fun toModifier(): Modifier = Modifier
        .setVariable(Vars.ContainerColor, containerColor)
        .setVariable(Vars.ContentColor, contentColor)
        .thenIf(borderColor != Color.Unspecified) {
            Modifier.setVariable(Vars.BorderColor, contentColor)
        }
        .setVariable(Vars.DisabledContainerColor, disabledContainerColor)
        .setVariable(Vars.DisabledContentColor, disabledContentColor)
        .thenIf(disabledBorderColor != Color.Unspecified) {
            Modifier.setVariable(Vars.DisabledBorderColor, contentColor)
        }
        .setVariable(Vars.HoverContainerColor, hoverContainerColor)
        .setVariable(Vars.HoverContentColor, hoverContentColor)
        .thenIf(hoverBorderColor != Color.Unspecified) {
            Modifier.setVariable(Vars.HoverBorderColor, hoverBorderColor)
        }
}

@Immutable
@ConsistentCopyVisibility
data class ButtonElevation internal constructor(
    private val defaultElevation: Elevation,
    private val pressedElevation: Elevation,
    private val focusedElevation: Elevation,
    private val hoveredElevation: Elevation,
    private val disabledElevation: Elevation,
) {
    fun toModifier(): Modifier = Modifier
        .setVariable(Vars.DefaultElevation, defaultElevation.shadows.joinToString())
        .setVariable(Vars.PressedElevation, pressedElevation.shadows.joinToString())
        .setVariable(Vars.FocusedElevation, focusedElevation.shadows.joinToString())
        .setVariable(Vars.HoveredElevation, hoveredElevation.shadows.joinToString())
        .setVariable(Vars.DisabledElevation, disabledElevation.shadows.joinToString())
}
