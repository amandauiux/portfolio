package com.amandabicalho.portfolio.components.template.home

import Res
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
            text = Res.string.what_i_do_title,
            style = Theme.typography.headlineMedium,
            modifier = WhatIDoTitleStyle.toModifier(),
        )
        Text(
            text = Res.string.what_i_do_description,
            style = Theme.typography.bodyLarge,
            modifier = WhatIDoDescriptionStyle.toModifier(),
        )

        GridSection(
            modifier = WhatIDoCardSectionStyle.toModifier(),
        ) {
            ServiceCard(
                title = Res.string.services_website_title,
                description = Res.string.services_website_description,
                imageUrl = "images/ic_ui.svg",
                imageDescription = Res.string.services_website_img_description,
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = Res.string.services_product_title,
                description = Res.string.services_product_description,
                imageUrl = "images/ic_user_experience.svg",
                imageDescription = Res.string.services_product_img_description,
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = Res.string.services_mobile_title,
                description = Res.string.services_mobile_description,
                imageUrl = "images/ic_product.svg",
                imageDescription = Res.string.services_mobile_img_description,
                modifier = WhatIDoServiceCardStyle.toModifier(),
            )
        }
    }
}
