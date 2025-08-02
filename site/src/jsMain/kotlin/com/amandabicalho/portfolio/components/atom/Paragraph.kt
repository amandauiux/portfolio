package com.amandabicalho.portfolio.components.atom

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.TextStyle
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.typography
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLParagraphElement

val ParagraphStyle = CssStyle {
    base {
        typography.bodyLarge.toModifier()
    }
}

@Composable
fun Paragraph(
    text: String,
    style: TextStyle? = null,
    modifier: Modifier = Modifier,
) {
    Paragraph(style = style, modifier = modifier) {
        Text(value = text)
    }
}

@Composable
fun Paragraph(
    style: TextStyle? = null,
    modifier: Modifier = Modifier,
    content: ContentBuilder<HTMLParagraphElement>? = null
) {
    val paragraphModifier = ParagraphStyle.toModifier().thenIf(style != null) {
        style?.toModifier(Theme.typography.bodyLarge) ?: Modifier
    }
    P(
        attrs = (paragraphModifier then modifier).toAttrs(),
        content = content,
    )
}
