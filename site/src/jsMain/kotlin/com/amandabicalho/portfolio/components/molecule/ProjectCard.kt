package com.amandabicalho.portfolio.components.molecule

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.ArrowForward
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Circle
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.color.copy
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.typography
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.css.functions.calc
import com.varabyte.kobweb.compose.dom.disposableRef
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translate
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.s
import org.w3c.dom.events.Event
import org.w3c.dom.events.MouseEvent

val ProjectCardStyle = CssStyle {
    base {
        Modifier
            .height(Height.FitContent)
            .cursor(Cursor.Pointer)
    }

    cssRule("> .base-text") {
        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .styleModifier {
                property("text-decoration-color", "transparent")
            }
            .transition {
                property("text-decoration-color")
                duration(0.3.s)
                timingFunction(TransitionTimingFunction.EaseInOut)
            }
    }

    cssRule(":hover > .base-text") {
        Modifier
            .styleModifier {
                property("text-decoration-color", colorScheme.black)
            }
    }
}

val ProjectCardTitleStyle = CssStyle {
    base {
        typography
            .titleMedium
            .toModifier()
    }
}

val ProjectCardTagContainerStyle = CssStyle {
    base {
        Modifier.padding(top = 16.dp, bottom = 8.dp)
    }
}

val ProjectCardImageContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .overflow(Overflow.Hidden)
            .cursor(Cursor.None)
    }

    cssRule(":hover") {
        Modifier.setVariable(ProjectCardVars.HoverElementOpacity, 1f)
    }
}

val ProjectCardHoverElementStyle = CssStyle {
    base {
        typography
            .bodySmall
            .copy(color = colorScheme.white)
            .toModifier()
            .display(DisplayStyle.Flex)
            .gap(8.dp)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .position(Position.Absolute)
            .translate(
                tx = calc { ProjectCardVars.HoverElementX.value(0.dp) - 50.dp },
                ty = calc { ProjectCardVars.HoverElementY.value(0.dp) - 50.dp }
            )
            .borderRadius(20.dp)
            .background { color(colorScheme.primary[30].copy(alpha = 0.95f)) }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .opacity(ProjectCardVars.HoverElementOpacity.value(0f))
            .transition(
                Transition.of(
                    property = "opacity",
                    duration = 0.1.s,
                    timingFunction = TransitionTimingFunction.EaseInOut,
                ),
                Transition.of(property = "translate", duration = 0.02.s),
            )
            .boxShadow(
                BoxShadow.of(
                    offsetX = 2.dp,
                    offsetY = 2.dp,
                    blurRadius = 6.dp,
                    spreadRadius = 0.dp,
                    color = colorScheme.black.copy(alpha = 0.12f),
                ),
                BoxShadow.of(
                    offsetX = (-2).dp,
                    offsetY = 0.dp,
                    blurRadius = 4.dp,
                    spreadRadius = 0.dp,
                    color = colorScheme.black.copy(alpha = 0.12f),
                ),
            )
    }
}

val ProjectCardImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(Height.FitContent)
            .aspectRatio(3, 2)
    }
}

val ProjectCardTagTextStyle = CssStyle {
    base {
        typography
            .bodyMedium
            .toModifier()
            .textTransform(TextTransform.Uppercase)
    }
}

object ProjectCardVars {
    val HoverElementX by StyleVariable<Dp>()
    val HoverElementY by StyleVariable<Dp>()
    val HoverElementOpacity by StyleVariable<Float>()
}

@Composable
fun ProjectCard(
    image: String,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tags: List<String> = emptyList(),
) {
    Column(
        modifier = ProjectCardStyle
            .toModifier()
            .then(modifier)
            .onClick { onClick() },
    ) {
        Box(
            modifier = ProjectCardImageContainerStyle.toModifier(),
            ref = disposableRef { element ->
                val onMouseMove = onMouseMove@{ event: Event ->
                    if (event !is MouseEvent) return@onMouseMove
                    val bounds = element.getBoundingClientRect()
                    element.style.apply {
                        setProperty(
                            property = "--${ProjectCardVars.HoverElementX.name}",
                            value = "${event.clientX - bounds.x}px"
                        )

                        setProperty(
                            property = "--${ProjectCardVars.HoverElementY.name}",
                            value = "${event.clientY - bounds.y}px",
                        )
                    }
                }

                element.addEventListener(type = "mousemove", callback = onMouseMove, options = false)

                onDispose {
                    element.removeEventListener(type = "mousemove", callback = onMouseMove, options = false)
                }
            },
        ) {
            Row(
                modifier = ProjectCardHoverElementStyle.toModifier(),
            ) {
                Text(text = Res.string.view_case_study, style = Theme.typography.bodySmall)
                ArrowForward()
            }
            Image(
                src = image,
                modifier = ProjectCardImageStyle.toModifier(),
            )
        }
        if (tags.isNotEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = ProjectCardTagContainerStyle.toModifier(),
            ) {
                tags.forEachIndexed { index, tag ->
                    if (index > 0) {
                        Circle(modifier = Modifier.size(12.dp))
                    }
                    Text(
                        text = tag,
                        modifier = ProjectCardTagTextStyle.toModifier(),
                    )
                }
            }
        }
        Text(
            text = title,
            modifier = ProjectCardTitleStyle.toModifier(),
        )
    }
}
