package com.amandabicalho.portfolio.designsystem.components.template

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSectionDefaults
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val HeroContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(12.dp)
            .gridColumn(start = GridSectionDefaults.LEFT_AREA, end = GridSectionDefaults.RIGHT_AREA)
    }
    Breakpoint.MD {
        Modifier
            .gap(20.dp)
            .gridArea(GridSectionDefaults.LEFT_AREA)
    }
}

@Composable
fun HeroSection(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
) {
    GridSection(
        modifier = modifier,
        useHeader = true,
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
