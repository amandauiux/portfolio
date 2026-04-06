package com.amandabicalho.portfolio.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.components.atom.Text
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px

val ServiceCardStyle = CssStyle {
    base {
        Modifier
    }
    Breakpoint.LG {
        Modifier.padding(right = 40.dp)
    }
}

val ServiceCardDescriptionStyle = CssStyle {
    Breakpoint.LG {
        Modifier
            .fontSize(16.px)
            .lineHeight(24.px)
    }
}

@Composable
fun ServiceCard(
    title: String,
    description: String,
    imageUrl: String,
    imageDescription: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = ServiceCardStyle
            .toModifier()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            src = imageUrl,
            alt = imageDescription,
            modifier = Modifier
                .size(58.dp),
        )
        Text(
            text = title,
            style = Theme.typography.titleMedium,
        )
        Text(
            text = description,
            style = Theme.typography.bodyMedium,
            modifier = ServiceCardDescriptionStyle.toModifier(),
        )
    }
}
