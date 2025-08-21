package com.amandabicalho.portfolio.components.atom

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.TextStyle
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.typography
import com.amandabicalho.portfolio.ui.theme.DesktopTypography
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.registerRefScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanTextKind
import com.varabyte.kobweb.silk.components.text.SpanTextStyle
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.H5
import org.jetbrains.compose.web.dom.H6
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

sealed interface TextKind : ComponentKind

val BaseTextStyle = CssStyle<TextKind> {
    base {
        typography.bodyLarge.toModifier() // Mobile-first (from updated Type.kt)
    }
    Breakpoint.MD {
        DesktopTypography.bodyLarge.toModifier()
    }
}

val HeadlineLargeVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineLarge.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.headlineLarge.toModifier()
    }
}
val HeadlineMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineMedium.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.headlineMedium.toModifier()
    }
}
val HeadlineSmallVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineSmall.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.headlineSmall.toModifier()
    }
}
val TitleLargeVariant = BaseTextStyle.addVariant {
    base {
        typography.titleLarge.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.titleLarge.toModifier()
    }
}
val TitleMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.titleMedium.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.titleMedium.toModifier()
    }
}
val TitleSmallVariant = BaseTextStyle.addVariant {
    base {
        typography.titleSmall.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.titleSmall.toModifier()
    }
}
val BodyLargeVariant = BaseTextStyle.addVariant { // This is already the BaseTextStyle, but for consistency
    base {
        typography.bodyLarge.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.bodyLarge.toModifier()
    }
}
val BodyMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.bodyMedium.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.bodyMedium.toModifier()
    }
}
val BodySmallVariant = BaseTextStyle.addVariant {
    base {
        typography.bodySmall.toModifier()
    }
    Breakpoint.MD {
        DesktopTypography.bodySmall.toModifier()
    }
}

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle? = null,
    ref: ElementRefScope<HTMLSpanElement>? = null,
    disablePreWrap: Boolean = false,
) {
    when {
        style?.isStyle(Theme.typography.headlineLarge) == true -> H1(
            attrs = BaseTextStyle
                .toModifier(HeadlineLargeVariant)
                .then(style.toModifier(diff = Theme.typography.headlineLarge)) // diff might need adjustment
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.headlineMedium) == true -> H2(
            attrs = BaseTextStyle
                .toModifier(HeadlineMediumVariant)
                .then(style.toModifier(diff = Theme.typography.headlineMedium))
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.headlineSmall) == true -> H3(
            attrs = BaseTextStyle
                .toModifier(HeadlineSmallVariant)
                .then(style.toModifier(diff = Theme.typography.headlineSmall))
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.titleLarge) == true -> H4(
            attrs = BaseTextStyle
                .toModifier(TitleLargeVariant)
                .then(style.toModifier(diff = Theme.typography.titleLarge))
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.titleMedium) == true -> H5(
            attrs = BaseTextStyle
                .toModifier(TitleMediumVariant)
                .then(style.toModifier(diff = Theme.typography.titleMedium))
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.titleSmall) == true -> H6(
            attrs = BaseTextStyle
                .toModifier(TitleSmallVariant)
                .then(style.toModifier(diff = Theme.typography.titleSmall))
                .then(modifier)
                .toAttrs(),
        ) {
            Text(value = text)
        }

        style?.isStyle(Theme.typography.bodyLarge) == true -> SpanText(
            text = text,
            modifier = BaseTextStyle
                .toModifier(BodyLargeVariant)
                .then(style.toModifier(Theme.typography.bodyLarge))
                .then(modifier),
        )

        style?.isStyle(Theme.typography.bodyMedium) == true -> SpanText(
            text = text,
            modifier = BaseTextStyle
                .toModifier(BodyMediumVariant)
                .then(style.toModifier(Theme.typography.bodyMedium))
                .then(modifier),
        )

        style?.isStyle(Theme.typography.bodySmall) == true -> SpanText(
            text = text,
            modifier = BaseTextStyle
                .toModifier(BodySmallVariant)
                .then(style.toModifier(Theme.typography.bodySmall))
                .then(modifier),
        )

        else -> SpanText(
            text = text,
            modifier = BaseTextStyle.toModifier() then style.toModifier() then modifier
                .thenIf(disablePreWrap) {
                    Modifier.whiteSpace(WhiteSpace.Unset)
                },
            ref = ref,
        )
    }
}

private fun TextStyle.isStyle(style: TextStyle): Boolean = // This might need review due to Theme changes
    this.fontFamily == style.fontFamily
        && this.fontStyle == style.fontStyle
        && this.fontWeight == style.fontWeight
        && this.fontSize == style.fontSize
        && this.lineHeight == style.lineHeight
        && this.letterSpacing == style.letterSpacing

/**
 * Fork of [com.varabyte.kobweb.silk.components.text.SpanText] to remove the obligatory [WhiteSpace.PreWrap]
 */
@Composable
private fun SpanText(
    text: String,
    modifier: Modifier = Modifier,
    variant: CssStyleVariant<SpanTextKind>? = null,
    ref: ElementRefScope<HTMLSpanElement>? = null,
) {
    val finalModifier = SpanTextStyle
        .toModifier(variant)
        .then(modifier)

    Span(attrs = finalModifier.toAttrs()) {
        registerRefScope(ref)
        Text(text)
    }
}
