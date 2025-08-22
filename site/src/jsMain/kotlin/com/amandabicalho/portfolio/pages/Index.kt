package com.amandabicalho.portfolio.pages

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.template.HeroSection
import com.amandabicalho.portfolio.components.template.PageLayoutData
import com.amandabicalho.portfolio.components.template.home.Expertise
import com.amandabicalho.portfolio.components.template.home.FeaturedProjects
import com.amandabicalho.portfolio.components.template.home.HighlightSection
import com.amandabicalho.portfolio.core.analytics.LocalAnalyticsManager
import com.amandabicalho.portfolio.core.analytics.events.AnalyticEvent
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.Projects
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BackgroundImage
import com.varabyte.kobweb.compose.css.BackgroundRepeat
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundRepeat
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
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
private val PaddingHorizontalMobile = 16.dp
val HomeContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .gap(40.dp)
    }
    Breakpoint.MD {
        Modifier
            .gap(80.dp)
    }
}

val HomeHeaderStyle = CssStyle {
    base {
        Modifier
            .background(
                Background.of(image = BackgroundImage.of(url("images/bg_home_header.svg"))),
                Background.of(
                    image = BackgroundImage.of(
                        gradient = linearGradient(angle = 180.deg) {
                            add(Color.argb(0xFFFFFFFF), 46.95.percent)
                            add(Color.rgba(255, 255, 255, 0), 100.percent)
                        },
                    ),
                ),
            )
            .background { repeat(BackgroundRepeat.Round) }
            .padding(horizontal = PaddingHorizontalMobile, vertical = 40.dp)
            .fillMaxWidth()
            .padding(bottom = 80.dp)
    }
    Breakpoint.MD {
        Modifier
            .background(
                Background.of(image = BackgroundImage.of(url("images/bg_home_header.svg"))),
                Background.of(
                    image = BackgroundImage.of(
                        gradient = linearGradient(angle = 90.deg) {
                            add(Color.argb(0xFFFFFFFF), 24.71.percent)
                            add(Color.rgba(255, 255, 255, 0), 100.percent)
                        },
                    ),
                ),
            )
            .backgroundRepeat(BackgroundRepeat.Round)
            .padding(horizontal = PaddingHorizontalDesktop, vertical = 80.dp)
            .padding(bottom = 20.dp)
    }
}

val HomeFeaturedProjectsStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontalMobile)
    }
    Breakpoint.MD {
        Modifier
            .padding(horizontal = PaddingHorizontalDesktop)
    }
}

val HomeWhatIDoStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontalMobile)
    }
    Breakpoint.MD {
        Modifier
            .padding(horizontal = PaddingHorizontalDesktop)
    }
}

val HomeHighlightsStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontalMobile)
    }
    Breakpoint.MD {
        Modifier
            .padding(horizontal = PaddingHorizontalDesktop)
    }
}

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Page
@Layout(".components.template.PageLayout")
@Composable
fun HomePage(context: PageContext) {
    val analytics = LocalAnalyticsManager.current
    Column(modifier = HomeContainerStyle.toModifier()) {
        HeroSection(
            title = Res.string.home_title,
            subtitle = Res.string.home_subtitle,
            modifier = HomeHeaderStyle.toModifier(),
        )
        FeaturedProjects(
            projects = Projects
                .entries
                .sortedByDescending { it.publishedAt }
                .take(n = 4),
            onViewAllProjectClick = {
                analytics.track(AnalyticEvent.ViewAllProjects)
                context.router.navigateTo("/projects")
            },
            onProjectClick = { project ->
                analytics.track(
                    AnalyticEvent.ViewProject(
                        projectTitle = project.title,
                        projectUrl = project.route,
                    ),
                )
                context.router.navigateTo(project.route)
            },
            modifier = HomeFeaturedProjectsStyle.toModifier(),
        )
        Expertise(
            modifier = HomeWhatIDoStyle.toModifier(),
        )
        HighlightSection(
            modifier = HomeHighlightsStyle.toModifier(),
        )
        Spacer()
    }
}
