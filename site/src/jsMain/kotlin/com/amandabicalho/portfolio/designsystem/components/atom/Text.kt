package com.amandabicalho.portfolio.designsystem.components.atom

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.TextStyle
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.amandabicalho.portfolio.typography
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
        typography.bodyLarge.copy(
            fontSize = 18.sp,
            lineHeight = 27.sp,
        ).toModifier()
    }
}

val HeadlineLargeVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineLarge.toModifier()
    }
    Breakpoint.MD {
        typography.headlineLarge.copy(
            fontSize = 96.sp,
            lineHeight = 115.2.sp,
        ).toModifier()
    }
}
val HeadlineMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineMedium.toModifier()
    }
    Breakpoint.MD {
        typography.headlineMedium.copy(
            fontSize = 80.sp,
            lineHeight = 96.sp,
        ).toModifier()
    }
}
val HeadlineSmallVariant = BaseTextStyle.addVariant {
    base {
        typography.headlineSmall.toModifier()
    }
    Breakpoint.MD {
        typography.headlineSmall.copy(
            fontSize = 60.sp,
            lineHeight = 72.sp,
        ).toModifier()
    }
}
val TitleLargeVariant = BaseTextStyle.addVariant {
    base {
        typography.titleLarge.toModifier()
    }
    Breakpoint.MD {
        typography.titleLarge.copy(
            fontSize = 36.sp,
            lineHeight = 46.8.sp,
        ).toModifier()
    }
}
val TitleMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.titleMedium.toModifier()
    }
    Breakpoint.MD {
        typography.titleMedium.copy(
            fontSize = 32.sp,
            lineHeight = 41.6.sp,
        ).toModifier()
    }
}
val TitleSmallVariant = BaseTextStyle.addVariant {
    base {
        typography.titleSmall.toModifier()
    }
    Breakpoint.MD {
        typography.titleSmall.copy(
            fontSize = 24.sp,
            lineHeight = 31.2.sp,
        ).toModifier()
    }
}
val BodyLargeVariant = BaseTextStyle.addVariant { // This is already the BaseTextStyle, but for consistency
    base {
        typography.bodyLarge.toModifier()
    }
    Breakpoint.MD {
        typography.bodyLarge.copy(
            fontSize = 18.sp,
            lineHeight = 27.sp,
        ).toModifier()
    }
}
val BodyMediumVariant = BaseTextStyle.addVariant {
    base {
        typography.bodyMedium.toModifier()
    }
    Breakpoint.MD {
        typography.bodyMedium.copy(
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ).toModifier()
    }
}
val BodySmallVariant = BaseTextStyle.addVariant {
    base {
        typography.bodySmall.toModifier()
    }
    Breakpoint.MD {
        typography.bodySmall.copy(
            fontSize = 14.sp,
            lineHeight = 21.sp,
        ).toModifier()
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
        .thenIf(text.startsWith(' ') || text.endsWith(' ')) {
            Modifier.whiteSpace(WhiteSpace.PreWrap)
        }
        .then(modifier)

    Span(attrs = finalModifier.toAttrs()) {
        registerRefScope(ref)
        Text(text)
    }
}
