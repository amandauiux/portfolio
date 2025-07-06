package com.amandabicalho.portfolio.pages

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.template.PageLayoutData
import com.amandabicalho.portfolio.designsystem.components.template.about.AboutHero
import com.amandabicalho.portfolio.designsystem.components.template.about.AboutMeSection
import com.amandabicalho.portfolio.designsystem.components.template.about.AboutWorkExperience
import com.amandabicalho.portfolio.domain.WorkExperience
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.datetime.LocalDate

val AboutPageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp, vertical = 80.dp)
            .gap(80.dp) // Gap between major sections
    }
}

@InitRoute
fun initAboutPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("About"))
}

@Page("/about")
@Layout(".designsystem.components.template.PageLayout")
@Composable
fun AboutPage() {
    Column(
        modifier = AboutPageStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AboutHero()
        AboutMeSection()
        AboutWorkExperience(
            experiences = listOf(
                WorkExperience(
                    title = "UX Designer at The ChangeMakers",
                    description = "Brief description",
                    startDate = LocalDate.parse("2024-01-01"),
                ),
                WorkExperience(
                    title = "UX/UI Designer at StayShure",
                    description = "Brief description",
                    startDate = LocalDate.parse("2023-01-01"),
                    endDate = LocalDate.parse("2024-01-01"),
                ),
                WorkExperience(
                    title = "Freelancer designer",
                    description = "Brief description",
                    startDate = LocalDate.parse("2023-01-01"),
                    endDate = LocalDate.parse("2023-01-01"),
                ),
                WorkExperience(
                    title = "UX/UI Designer at ioasys",
                    description = "Brief description",
                    startDate = LocalDate.parse("2022-01-01"),
                    endDate = LocalDate.parse("2023-01-01"),
                ),
            ),
            onViewResumeClick = { /* Handle resume click */ },
        )
    }
}
