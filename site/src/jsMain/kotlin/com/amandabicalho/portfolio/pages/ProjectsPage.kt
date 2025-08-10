package com.amandabicalho.portfolio.pages

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.template.HeroSection
import com.amandabicalho.portfolio.components.template.PageLayoutData
import com.amandabicalho.portfolio.components.template.project.OtherProjectsSection
import com.amandabicalho.portfolio.components.template.project.ProjectsSection
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BackgroundImage
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundRepeat
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.heightIn
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent

private val PaddingHorizontalDesktop = 40.dp
private val PaddingHorizontalMobile = 20.dp
val ProjectsPageStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
    }
}

val ProjectHeaderStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .heightIn(min = 232.dp)
            .padding(vertical = 40.dp, horizontal = PaddingHorizontalMobile)
            .background(
                Background.of(image = BackgroundImage.of(url("images/bg_home_header.svg"))),
                Background.of(
                    image = BackgroundImage.of(
                        gradient = linearGradient(angle = 90.deg) {
                            add(Color.argb(0xFFFFFCF7), 24.71.percent)
                            add(Color.rgba(255, 255, 255, 0), 100.percent)
                        },
                    ),
                ),
            )
            .backgroundRepeat(BackgroundRepeat.Round)
            .gap(40.dp)
    }
    Breakpoint.MD {
        Modifier
            .heightIn(min = 533.dp)
            .padding(top = 80.dp, bottom = 20.dp, start = PaddingHorizontalDesktop, end = PaddingHorizontalDesktop)
            .gap(20.dp)
    }
}

val ProjectContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(40.dp)
            .padding(bottom = 64.dp)
            .margin(top = (-100).dp)
    }
    Breakpoint.MD {
        Modifier
            .fillMaxWidth()
            .gap(80.dp)
            .padding(bottom = 120.dp)
            .margin(top = (-258).dp)
    }
}

val ProjectSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingHorizontalMobile)
    }
    Breakpoint.MD {
        Modifier
            .padding(horizontal = PaddingHorizontalDesktop)
    }
}

val OtherProjectsSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingHorizontalMobile)
    }
    Breakpoint.MD {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingHorizontalDesktop)
    }
}

@InitRoute
fun initProjectsPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(title = Res.string.projects))
}

@Page("/projects")
@Layout(".components.template.PageLayout")
@Composable
fun ProjectsPage() {
    Column(
        modifier = ProjectsPageStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeroSection(
            title = Res.string.projects,
            modifier = ProjectHeaderStyle.toModifier(),
        )

        Column(
            modifier = ProjectContentStyle.toModifier(),
        ) {
            ProjectsSection(modifier = ProjectSectionStyle.toModifier())
            OtherProjectsSection(modifier = OtherProjectsSectionStyle.toModifier())
        }
    }
}
