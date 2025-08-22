package com.amandabicalho.portfolio.components.template.home

import Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridVars
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.Regular
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.amandabicalho.portfolio.typography
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BackgroundImage
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.content
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

val HighlightSectionStyle = CssStyle {
    base {
        Modifier.setVariable(GridVars.RowGap, 32.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 40.dp)
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
            .margin(0.dp)
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.RIGHT_AREA)
            .padding(start = 24.dp)
    }

    cssRule("li") {
        typography
            .titleSmall
            .copy(
                fontWeight = FontWeight.Regular,
            )
            .toModifier()
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .alignItems(AlignItems.Center)
            .gap(16.dp)
            .padding(vertical = 12.dp)
    }

    cssRule("li::before") {
        Modifier
            .display(DisplayStyle.Block)
            .content(" ")
            .background(
                Background.of(
                    BackgroundImage.of(
                        url = url(value = BasePath.prependTo(path = "images/icons/ic_circle.svg")),
                    ),
                ),
            )
            .width(16.dp)
            .height(16.dp)
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
    cssRule("li > span") {
        Modifier.flex(1)
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
        Span {
            B {
                Text(value = title)
            }
            Text(value = description)
        }
    }
}
