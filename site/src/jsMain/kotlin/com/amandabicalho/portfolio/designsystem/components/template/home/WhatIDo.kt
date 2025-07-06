package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSectionDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSectionVars
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.designsystem.components.molecule.ServiceCard
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnEnd
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnStart
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val WhatIDoStyle = CssStyle {
    base {
        Modifier.setVariable(GridSectionVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridSectionVars.RowGap, 80.dp)
    }
}
val WhatIDoTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridSectionDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridSectionDefaults.LEFT_AREA)
    }
}

val WhatIDoDescriptionStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridSectionDefaults.MOBILE_AREA_SIZE}")
            .margin(bottom = 28.dp)
    }

    Breakpoint.MD {
        Modifier
            .gridArea(GridSectionDefaults.RIGHT_AREA)
            .margin(bottom = 0.dp)
    }
}

val WhatIDoCardSectionStyle = CssStyle {
    base {
        Modifier
            .gridColumnStart(GridSectionDefaults.LEFT_AREA)
            .gridColumnEnd(GridSectionDefaults.RIGHT_AREA)
            .setVariable(GridSectionVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridSectionVars.RowGap, 80.dp)
    }
}

val WhatIDoServiceCardStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridSectionDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridColumn("span ${GridSectionDefaults.DESKTOP_AREA_SIZE / 3}")
    }
}

@Composable
fun WhatIDo(modifier: Modifier) {
    GridSection(
        modifier = WhatIDoStyle
            .toModifier()
            .then(modifier),
    ) {
        Text(
            text = "What I do",
            style = Theme.typography.headlineMedium,
            modifier = WhatIDoTitleStyle.toModifier(),
        )
        Text(
            text = "[services] Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed. Cursus orci adipiscing id scelerisque ipsum. Nunc viverra feugiat nunc volutpat lobortis sed. Integer ac fringilla nunc egestas.",
            style = Theme.typography.bodyLarge,
            modifier = WhatIDoDescriptionStyle.toModifier(),
        )

        GridSection(
            modifier = WhatIDoCardSectionStyle.toModifier(),
        ) {
            ServiceCard(
                title = "User interface",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_ui.svg",
                imageDescription = "User interface icon",
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = "User experience",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_user_experience.svg",
                imageDescription = "User experience icon",
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = "Product",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_product.svg",
                imageDescription = "Product icon",
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
        }
    }
}
