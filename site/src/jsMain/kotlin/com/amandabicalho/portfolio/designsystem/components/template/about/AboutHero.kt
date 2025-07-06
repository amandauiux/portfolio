package com.amandabicalho.portfolio.designsystem.components.template.about

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
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
                text = "Hi, I'm Amanda",
                style = Theme.typography.headlineLarge.copy(
                    color = Theme.colorScheme.primary[30]
                ),
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Natoque blandit ut ultrices ac. Nam metus cras neque sed. Cursus orci adipiscing id condimentum vitae massa. Vitae sagittis sed ut sit id lobortis sed. Integer ac fringilla nunc egestas. Quis metus adipiscing blandit faucibus.",
                style = Theme.typography.bodyLarge,
            )
        }
        Image(
            src = "images/profile_drawing.png",
            description = "Amanda Bicalho profile drawing",
            modifier = AboutHeroImageStyle.toModifier()
        )
    }
}
