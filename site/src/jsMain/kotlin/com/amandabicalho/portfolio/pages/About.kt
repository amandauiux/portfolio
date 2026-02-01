package com.amandabicalho.portfolio.pages

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.template.PageLayoutData
import com.amandabicalho.portfolio.components.template.about.AboutHero
import com.amandabicalho.portfolio.components.template.about.AboutApproach
import com.amandabicalho.portfolio.components.template.about.AboutWorkExperience
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.datetime.LocalDate

val AboutPageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 40.dp)
            .gap(40.dp)
    }

    Breakpoint.LG {
        Modifier
            .padding(horizontal = 36.dp, vertical = 80.dp)
            .gap(80.dp)
    }
}

@InitRoute
fun initAboutPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("About"))
}

@Page("/about")
@Layout(".components.template.PageLayout")
@Composable
fun AboutPage() {
    Column(
        modifier = AboutPageStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AboutHero()
        AboutApproach()
        AboutWorkExperience(
            experiences = listOf(
                WorkExperience(
                    title = "UX Designer",
                    company = "The ChangeMakers",
                    url = "https://thechangemakers.com",
                    startDate = LocalDate.parse("2024-01-01"),
                ),
                WorkExperience(
                    title = "UX/UI Designer",
                    company = "StayShure",
                    url = "https://www.linkedin.com/company/stayshure/posts/?feedView=all",
                    startDate = LocalDate.parse("2023-01-01"),
                    endDate = LocalDate.parse("2024-01-01"),
                ),
                WorkExperience(
                    title = "UX/UI Designer",
                    company = "ioasys",
                    url = "https://ioasys.com.br",
                    startDate = LocalDate.parse("2022-01-01"),
                    endDate = LocalDate.parse("2023-01-01"),
                ),
            ),
        )
    }
}
