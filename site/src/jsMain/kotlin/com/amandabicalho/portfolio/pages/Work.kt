package com.amandabicalho.portfolio.pages

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.template.PageLayoutData
import com.amandabicalho.portfolio.designsystem.components.template.home.HeroSection
import com.amandabicalho.portfolio.designsystem.components.template.work.OtherWorksSection
import com.amandabicalho.portfolio.designsystem.components.template.work.WorkSection
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BackgroundImage
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.background
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
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent

val WorkPageStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
    }
}

val WorkHeaderStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .heightIn(min = 533.dp)
            .padding(top = 80.dp, bottom = 20.dp, start = 36.dp, end = 36.dp)
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
            .gap(20.dp)
    }
}

val WorkContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(80.dp)
            .padding(bottom = 120.dp)
            .margin(top = (-258).dp)
    }
}

val WorkSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
    }
}

val OtherWorksSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
    }
}

@InitRoute
fun initWorkPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Work"))
}

@Page("/work")
@Layout(".designsystem.components.template.PageLayout")
@Composable
fun WorkPage() {
    Column(
        modifier = WorkPageStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeroSection(
            title = "Work",
            modifier = WorkHeaderStyle.toModifier(),
        )

        Column(
            modifier = WorkContentStyle.toModifier(),
        ) {
            WorkSection(modifier = WorkSectionStyle.toModifier())
            OtherWorksSection(modifier = OtherWorksSectionStyle.toModifier())
        }
    }
}
