package com.amandabicalho.portfolio.components.template.showcase

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.desktopGrid
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

val ShowcaseSectionStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(12.dp)
            .padding(top = 40.dp)
    }

    Breakpoint.LG {
        Modifier.desktopGrid()
    }

    cssRule(Breakpoint.LG, "h3") {
        Modifier.gridColumn(GridDefaults.LEFT_AREA)
    }

    cssRule("ul > li") {
        Modifier.margin(left = 16.dp)
    }
}

val ShowcaseSectionTitleStyle = CssStyle {
    base {
        Modifier
    }

    Breakpoint.LG {
        Modifier.gridColumn(GridDefaults.LEFT_AREA)
    }
}

val ShowcaseSectionContentStyle = CssStyle {
    base {
        Modifier.gap(12.dp)
    }

    Breakpoint.LG {
        Modifier
            .gridColumn(GridDefaults.RIGHT_AREA)
            .gap(16.dp)
    }
}

@Composable
fun ShowcaseSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Section(
        attrs = ShowcaseSectionStyle.toModifier().then(modifier).toAttrs(),
    ) {
        H2(attrs = ShowcaseSectionTitleStyle.toAttrs()) {
            Text(value = title)
        }
        Column(modifier = ShowcaseSectionContentStyle.toModifier()) {
            content()
        }
    }
}
