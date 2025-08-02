package com.amandabicalho.portfolio.components.template.about

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Paragraph
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val AboutHeroSectionStyle = CssStyle {
    base { // Mobile first: Column layout
        Modifier
            .fillMaxWidth()
            .gap(40.dp)
    }
    Breakpoint.MD { // Tablet and up: Row layout
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(12) {
                    size(1.fr)
                }
            }
            .gap(24.dp)
    }
}

val AboutHeroTextStyle = CssStyle {
    base {
        Modifier
            .gap(20.dp)
    }
    Breakpoint.MD {
        Modifier
            .gridColumn(start = 1, end = 6)
    }
}

val AboutHeroImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .alignSelf(AlignSelf.Center)
    }
    Breakpoint.MD {
        Modifier
            .gridColumn(start = 7, end = 13)
    }
}

@Composable
fun AboutHero(modifier: Modifier = Modifier) {
    Section(
        attrs = AboutHeroSectionStyle
            .toModifier()
            .then(modifier)
            .toAttrs(),
    ) {
        Column(modifier = AboutHeroTextStyle.toModifier()) {
            Text(
                text = Res.string.about_welcome,
                style = Theme.typography.headlineLarge.copy(
                    color = Theme.colorScheme.primary[30]
                ),
            )
            Column {
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
        Image(
            src = "images/profile_drawing.png",
            description = Res.string.about_image_description,
            modifier = AboutHeroImageStyle.toModifier()
        )
    }
}
