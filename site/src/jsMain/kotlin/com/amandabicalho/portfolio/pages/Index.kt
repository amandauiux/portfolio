package com.amandabicalho.portfolio.pages

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.template.HeroSection
import com.amandabicalho.portfolio.designsystem.components.template.PageLayoutData
import com.amandabicalho.portfolio.designsystem.components.template.home.FeaturedWork
import com.amandabicalho.portfolio.designsystem.components.template.home.HighlightSection
import com.amandabicalho.portfolio.designsystem.components.template.home.WhatIDo
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
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent

private val PaddingHorizontal = 40.dp
val HomeContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
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
                        gradient = linearGradient(angle = 90.deg) {
                            add(Color.argb(0xFFFFFCF7), 24.71.percent)
                            add(Color.rgba(255, 255, 255, 0), 100.percent)
                        },
                    ),
                ),
            )
            .backgroundRepeat(BackgroundRepeat.Round)
            .padding(horizontal = PaddingHorizontal, vertical = 80.dp)
            .fillMaxWidth()
            .gap(20.dp)
            .padding(bottom = 20.dp)
    }
}

val HomeFeaturedWorkStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontal)
    }
}

val HomeWhatIDoStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontal)
    }
}

val HomeHighlightsStyle = CssStyle {
    base {
        Modifier
            .padding(horizontal = PaddingHorizontal)
    }
}

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Page
@Layout(".designsystem.components.template.PageLayout")
@Composable
fun HomePage() {
    Column(modifier = HomeContainerStyle.toModifier()) {
        HeroSection(
            title = "Lorem ipsum UX UI Designer",
            subtitle = "Hey, I’m Amanda, a strategic UX UI Designer delivering top-tier Websites, Mobile experiences, and good vibes, who loves learning about visual design and user behaviour.",
            modifier = HomeHeaderStyle.toModifier(),
        )
        FeaturedWork(
            modifier = HomeFeaturedWorkStyle.toModifier(),
            onViewAllProjectClick = {},
        )
        WhatIDo(
            modifier = HomeWhatIDoStyle.toModifier(),
        )
        HighlightSection(
            modifier = HomeHighlightsStyle.toModifier(),
        )
        Spacer()
    }
}
