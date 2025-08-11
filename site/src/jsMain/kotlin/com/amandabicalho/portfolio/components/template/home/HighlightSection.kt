package com.amandabicalho.portfolio.components.template.home

import Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.Regular
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.amandabicalho.portfolio.typography
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
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
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
            .padding(start = 24.dp)
            .margin(0.dp)
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.RIGHT_AREA)
    }

    cssRule("li") {
        typography
            .titleSmall
            .copy(
                fontWeight = FontWeight.Regular,
            )
            .toModifier()
            .listStyle(ListStyle.of(image = ListStyleImage.of(url("images/icons/ic_circle.svg"))))
            .padding(vertical = 20.dp)
    }

    cssRule(Breakpoint.MD.toCSSMediaQuery(), "li") {
        typography
            .titleSmall
            .copy(
                fontSize = 24.sp,
                lineHeight = 31.2.sp,
                fontWeight = FontWeight.Regular,
            )
            .toModifier()
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
            text = Res.string.home_big_statement,
            style = Theme.typography.headlineMedium.copy(
                color = Theme.colorScheme.primary[50],
            ),
            modifier = HighlightSectionTitleStyle.toModifier(),
        )

        Ul(attrs = HighlightSectionHighlightList.toAttrs()) {
            HighlightItem(
                text = Res.string.home_highlights_vision,
            )
            HighlightItem(
                text = Res.string.home_highlights_modern_effective,
            )
            HighlightItem(
                text = Res.string.home_highlights_driven_by_empathy,
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
        val separatorIndex = remember { text.indexOf(":") + 1 }
        val title = remember(text) {
            text.substring(startIndex = 0, endIndex = separatorIndex)
        }
        val description = remember(text) {
            text.substring(startIndex = separatorIndex, endIndex = text.length)
        }
        B {
            Text(value = title)
        }
        Text(value = description)
    }
}
