package com.amandabicalho.portfolio.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.ServiceCard
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridVars
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
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
        Modifier.setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}
val WhatIDoTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.LEFT_AREA)
    }
}

val WhatIDoDescriptionStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
            .margin(bottom = 28.dp)
    }

    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.RIGHT_AREA)
            .margin(bottom = 0.dp)
    }
}

val WhatIDoCardSectionStyle = CssStyle {
    base {
        Modifier
            .gridColumnStart(GridDefaults.LEFT_AREA)
            .gridColumnEnd(GridDefaults.RIGHT_AREA)
            .setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}

val WhatIDoServiceCardStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridColumn("span ${GridDefaults.DESKTOP_AREA_SIZE / 3}")
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
