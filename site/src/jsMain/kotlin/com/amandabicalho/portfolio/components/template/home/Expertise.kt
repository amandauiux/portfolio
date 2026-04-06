package com.amandabicalho.portfolio.components.template.home

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.ServiceCard
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridVars
import com.amandabicalho.portfolio.core.ui.animation.ScrollReveal
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
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
import com.varabyte.kobweb.silk.theme.colors.ColorMode

val ExpertiseStyle = CssStyle {
    base {
        Modifier.setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}
val ExpertiseTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.LEFT_AREA)
    }
}

val ExpertiseDescriptionStyle = CssStyle {
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

val ExpertiseCardSectionStyle = CssStyle {
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

val ExpertiseServiceCardStyle = CssStyle {
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
fun Expertise(modifier: Modifier) {
    val isDark = ColorMode.current == ColorMode.DARK
    val suffix = if (isDark) "_dark" else ""

    GridSection(
        modifier = ExpertiseStyle
            .toModifier()
            .then(modifier),
    ) {
        ScrollReveal(modifier = ExpertiseTitleStyle.toModifier()) {
            Text(
                text = Res.string.expertise_title,
                style = Theme.typography.headlineMedium,
            )
        }
        ScrollReveal(
            modifier = ExpertiseDescriptionStyle.toModifier(),
            delay = 100,
        ) {
            Text(
                text = Res.string.expertise_description,
                style = Theme.typography.bodyLarge,
            )
        }

        GridSection(
            modifier = ExpertiseCardSectionStyle.toModifier(),
        ) {
            ScrollReveal(modifier = ExpertiseServiceCardStyle.toModifier()) {
                ServiceCard(
                    title = Res.string.services_website_title,
                    description = Res.string.services_website_description,
                    imageUrl = BasePath.prependTo(path = "images/ic_ui$suffix.svg"),
                    imageDescription = Res.string.services_website_img_description,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                )
            }
            ScrollReveal(
                modifier = ExpertiseServiceCardStyle.toModifier(),
                delay = 150,
            ) {
                ServiceCard(
                    title = Res.string.services_product_title,
                    description = Res.string.services_product_description,
                    imageUrl = BasePath.prependTo(path = "images/ic_user_experience$suffix.svg"),
                    imageDescription = Res.string.services_product_img_description,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                )
            }
            ScrollReveal(
                modifier = ExpertiseServiceCardStyle.toModifier(),
                delay = 300,
            ) {
                ServiceCard(
                    title = Res.string.services_mobile_title,
                    description = Res.string.services_mobile_description,
                    imageUrl = BasePath.prependTo(path = "images/ic_product$suffix.svg"),
                    imageDescription = Res.string.services_mobile_img_description,
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                )
            }
        }
    }
}
