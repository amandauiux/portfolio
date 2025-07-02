package com.amandabicalho.portfolio.designsystem.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.LineStyle

val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .borderRadius(20.dp)
            .border {
                width(1.dp)
                color(colorScheme.gray)
                style(LineStyle.Solid)
            }
            .padding(20.dp)
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
        )
    }
}
