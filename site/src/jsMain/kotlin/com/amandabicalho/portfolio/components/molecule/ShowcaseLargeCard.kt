package com.amandabicalho.portfolio.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent

val ShowcaseLargeCardStyle = CssStyle {
    base {
        Modifier
            .height(Height.FitContent)
            .gap(16.dp)
    }
    Breakpoint.LG {
        Modifier
            .flexGrow(1)
            .flexBasis(48.percent)
    }
}

val ShowcaseLargeCardImageStyle = CssStyle {
    base {
        Modifier
            .height(Height.FitContent)
            .aspectRatio(1, 1)
            .objectFit(ObjectFit.Cover)
    }
}

@Composable
fun ShowcaseLargeCard(
    image: String,
    title: String,
    modifier: Modifier = Modifier,
    description: @Composable () -> Unit,
) {
    Column(modifier = ShowcaseLargeCardStyle.toModifier().then(modifier)) {
        Image(
            src = image,
            modifier = ShowcaseLargeCardImageStyle.toModifier(),
        )
        Text(
            text = title,
            style = Theme.typography.titleMedium,
        )
        description()
    }
}
