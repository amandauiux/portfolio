package com.amandabicalho.portfolio.components.template.about

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Paragraph
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.widthIn
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.toWidth
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Picture
import org.jetbrains.compose.web.dom.Source

val AboutHeroSectionStyle = CssStyle {
    base {
        Modifier.gap(40.dp)
    }
    Breakpoint.MD {
        Modifier.gap(80.dp)
    }
}

val AboutHeroContentContainerStyle = CssStyle {
    base {
        Modifier
            .gap(20.dp)
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
    Breakpoint.MD {
        Modifier.gridColumn(GridDefaults.LEFT_AREA)
    }
}

val AboutHeroParagraphStyle = CssStyle {
    base {
        Modifier.gap(12.dp)
    }
    Breakpoint.MD {
        Modifier.gap(20.dp)
    }
}

val AboutHeroPictureStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .fillMaxWidth()
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
    Breakpoint.MD {
        Modifier.gridColumn(GridDefaults.RIGHT_AREA)
    }

    cssRule("> img") {
        Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover)
    }

    cssRule(Breakpoint.MD, "> img") {
        Modifier.widthIn(max = 644.dp)
    }
}

@Composable
fun AboutHero(modifier: Modifier = Modifier) {
    GridSection(
        modifier = AboutHeroSectionStyle
            .toModifier()
            .then(modifier),
    ) {
        Column(modifier = AboutHeroContentContainerStyle.toModifier()) {
            Text(
                text = Res.string.about_welcome,
                style = Theme.typography.headlineLarge.copy(
                    color = Theme.colorScheme.primary[30]
                ),
                modifier = Modifier.whiteSpace(WhiteSpace.PreWrap),
            )
            Column(modifier = AboutHeroParagraphStyle.toModifier()) {
                Paragraph(
                    text = Res.string.about_me_paragraph_1,
                    style = Theme.typography.bodyLarge,
                )
                Paragraph(
                    text = Res.string.about_me_paragraph_2,
                    style = Theme.typography.bodyLarge,
                )
            }
        }
        Picture(
            attrs = AboutHeroPictureStyle.toAttrs(),
        ) {
            Source(
                attrs = {
                    attr("media", "(max-width: ${Breakpoint.SM.toWidth()})")
                    attr("srcset", "images/profile_drawing_small.png")
                }
            )
            Image(
                src = "images/profile_drawing.png",
                description = Res.string.about_image_description,
            )
        }
    }
}
