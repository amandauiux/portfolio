package com.amandabicalho.portfolio.components.template.about

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
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val AboutApproachStyle = CssStyle {
    base {
        Modifier.setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}
val AboutApproachTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.LEFT_AREA)
    }
}

val AboutApproachDescriptionStyle = CssStyle {
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

val AboutApproachCardSectionStyle = CssStyle {
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

val AboutApproachServiceCardStyle = CssStyle {
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
fun AboutApproach(modifier: Modifier = Modifier) {
    GridSection(
        modifier = AboutApproachStyle
            .toModifier()
            .then(modifier),
    ) {
        Text(
            text = Res.string.about_my_approach_title,
            style = Theme.typography.headlineMedium,
            modifier = AboutApproachTitleStyle.toModifier(),
        )
        Text(
            text = Res.string.about_my_approach_description,
            style = Theme.typography.bodyLarge,
            modifier = AboutApproachDescriptionStyle.toModifier(),
        )

        GridSection(
            modifier = AboutApproachCardSectionStyle.toModifier(),
        ) {
            ServiceCard(
                title = Res.string.about_approach_card1_title,
                description = Res.string.about_approach_card1_desc,
                imageUrl = BasePath.prependTo(path = "images/ic_process_focused.svg"),
                imageDescription = Res.string.about_approach_card1_img_desc,
                modifier = AboutApproachServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = Res.string.about_approach_card2_title,
                description = Res.string.about_approach_card2_desc,
                imageUrl = BasePath.prependTo(path = "images/ic_cross_functional.svg"),
                imageDescription = Res.string.about_approach_card2_img_desc,
                modifier = AboutApproachServiceCardStyle.toModifier(),
            )
            ServiceCard(
                title = Res.string.about_approach_card3_title,
                description = Res.string.about_approach_card3_desc,
                imageUrl = BasePath.prependTo(path = "images/ic_strategic_design.svg"),
                imageDescription = Res.string.about_approach_card3_img_desc,
                modifier = AboutApproachServiceCardStyle.toModifier(),
            )
        }
    }
}
