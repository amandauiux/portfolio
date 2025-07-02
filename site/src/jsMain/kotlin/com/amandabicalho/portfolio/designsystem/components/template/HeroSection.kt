package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.widthIn
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Header

val HeroContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .widthIn(max = 668.dp)
            .gap(20.dp)
    }
}

@Composable
fun HeroSection(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
) {
    Header(
        attrs = modifier.toAttrs(),
    ) {
        Column(HeroContainerStyle.toModifier()) {
            Text(
                text = title,
                style = Theme.typography.headlineLarge.copy(
                    color = Theme.colorScheme.primary[30],
                ),
            )
            subtitle?.let { subtitle ->
                Text(
                    text = subtitle,
                    style = Theme.typography.titleSmall,
                )
            }
        }
    }
}
