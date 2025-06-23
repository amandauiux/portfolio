package com.amandabicalho.portfolio.core.designsystem.components.organism

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.molecule.LogoButton
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.borderRight
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle

object SideBarVars {
    val BorderColor by StyleVariable<Color>()
}

val SideBarStyle = CssStyle.base {
    Modifier
        .fillMaxHeight()
        .borderRight {
            width(1.dp)
            color(SideBarVars.BorderColor.value())
            style(LineStyle.Solid)
        }
}

val SideBarLogoButtonStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .size(80.dp)
        .borderBottom {
            width(1.dp)
            color(SideBarVars.BorderColor.value())
            style(LineStyle.Solid)
        }
}

@Composable
fun SideBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = SideBarStyle.toModifier() then modifier
            .setVariable(SideBarVars.BorderColor, Theme.colorScheme.primary[30]),
    ) {
        LogoButton(
            modifier = SideBarLogoButtonStyle.toModifier(),
        )
    }
}
