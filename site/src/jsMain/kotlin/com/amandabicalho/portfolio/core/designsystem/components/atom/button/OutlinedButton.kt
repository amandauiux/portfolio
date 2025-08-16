package com.amandabicalho.portfolio.core.designsystem.components.atom.button

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.content
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.s

val OutlinedButtonVariant = ButtonStyle.addVariant {
    base {
        Modifier
            .position(Position.Relative)
    }
    cssRule("> div") {
        Modifier
            .position(Position.Relative)
            .zIndex(2)
            .border {
                color(ButtonDefaults.Vars.BorderColor.value())
                width(1.dp)
                style(LineStyle.Solid)
            }
            .borderRadius(ButtonDefaults.Vars.BorderRadius.value())
    }
    cssRule(":hover > div") {
        Modifier
            .color(ButtonDefaults.Vars.HoverContentColor.value())
            .border {
                color(ButtonDefaults.Vars.HoverBorderColor.value())
                width(1.dp)
                style(LineStyle.Solid)
            }
    }

    before {
        Modifier
            .fillMaxSize()
            .content(" ")
            .position(Position.Absolute)
            .display(DisplayStyle.InlineBlock)
            .borderRadius(ButtonDefaults.Vars.BorderRadius.value())
            .zIndex(1)
            .opacity(1f)
            .background(ButtonDefaults.Vars.HoverContainerColor.value())
            .opacity(0f)
            .top(0.dp)
            .left(0.dp)
            .transition {
                property("opacity", "top", "left", "border", "border-color", "background-color")
                duration(0.4.s)
                timingFunction(
                    AnimationTimingFunction.cubicBezier(
                        x1 = 0.34,
                        y1 = 1.56,
                        x2 = 0.64,
                        y2 = 1.0,
                    ),
                )
            }
    }

    (hover + before) {
        Modifier
            .opacity(1f)
            .top(4.dp)
            .left(4.dp)
    }
}

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        variant = OutlinedButtonVariant,
        colors = colors,
        contentPadding = contentPadding,
        elevation = null,
        content = content,
    )
}
