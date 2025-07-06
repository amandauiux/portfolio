package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSectionDefaults
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
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.listStyle
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

val HighlightSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(2) {
                    size(1.fr)
                }
            }
            .justifyContent(JustifyContent.SpaceBetween)
    }
}

val HighlightSectionHighlightList = CssStyle {
    base {
        Modifier
            .padding(start = 12.dp)
            .gridArea(GridSectionDefaults.RIGHT_AREA)
    }

    cssRule("li") {
        Modifier
            .listStyle(ListStyle.of(image = ListStyleImage.of(url("images/icons/ic_circle.svg"))))
            .padding(vertical = 20.dp)
            .margin(left = 24.dp)
    }
}

@Composable
fun HighlightSection(modifier: Modifier = Modifier) {
//    Section(
//        attrs = HighlightSectionStyle
//            .toModifier()
//            .then(modifier)
//            .toAttrs(),
//    ) {
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
            modifier = Modifier.gridArea(GridSectionDefaults.LEFT_AREA),
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
