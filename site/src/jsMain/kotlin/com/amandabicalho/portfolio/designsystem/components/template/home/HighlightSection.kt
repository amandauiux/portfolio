package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.Regular
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ListStyle
import com.varabyte.kobweb.compose.css.ListStyleImage
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.listStyle
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

val HighlightSectionStyle = CssStyle {
    base {
        Modifier
    }
}

val HighlightSectionTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.LEFT_AREA)
    }
}

val HighlightSectionHighlightList = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .padding(start = 12.dp)
            .margin(0.dp)
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.RIGHT_AREA)
    }

    cssRule("li") {
        Modifier
            .listStyle(ListStyle.of(image = ListStyleImage.of(url("images/icons/ic_circle.svg"))))
            .padding(vertical = 20.dp)
    }

    cssRule(Breakpoint.MD.toCSSMediaQuery(), "li") {
        Modifier
            .padding(vertical = 20.dp)
            .margin(left = 24.dp)
    }
}

@Composable
fun HighlightSection(modifier: Modifier = Modifier) {
    GridSection(
        modifier = HighlightSectionStyle
            .toModifier()
            .then(modifier),
    ) {
        Text(
            text = "Big statement Lorem ipsum",
            style = Theme.typography.headlineMedium.copy(
                color = Theme.colorScheme.primary[50],
            ),
            modifier = HighlightSectionTitleStyle.toModifier(),
        )

        Ul(attrs = HighlightSectionHighlightList.toAttrs()) {
            HighlightItem(
                text = "Give your product a fresh and modern UI",
            )
            HighlightItem(
                text = "Turn your idea into a tangible, real-world product",
            )
            HighlightItem(
                text = "Highlight lorem ipsom dolor siamet",
            )
            HighlightItem(
                text = "Highlight lorem ipsom dolor siamet",
            )
        }
    }
}

@Composable
private fun HighlightItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Li(attrs = modifier.toAttrs()) {
        Text(
            text = text,
            style = Theme.typography.titleSmall.copy(
                fontWeight = FontWeight.Regular,
            ),
        )
    }
}
