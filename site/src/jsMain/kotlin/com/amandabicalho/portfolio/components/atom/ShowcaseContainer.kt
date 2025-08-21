package com.amandabicalho.portfolio.components.atom

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.dom.Div

val ShowcaseContainerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .flexWrap(FlexWrap.Wrap)
            .gap(24.dp)
    }

    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Row)
    }
}

@Composable
fun ShowcaseContainer(
    content: @Composable () -> Unit,
) {
    Div(attrs = ShowcaseContainerStyle.toAttrs()) {
        content()
    }
}
