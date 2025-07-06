package com.amandabicalho.portfolio.designsystem.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Circle
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.typography
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier

val WorkCardStyle = CssStyle {
    base {
        Modifier
    }
}

val WorkCardTitleStyle = CssStyle {
    base {
        typography
            .titleMedium
            .toModifier()
    }
}

val WorkCardTagContainerStyle = CssStyle {
    base {
        Modifier.padding(top = 16.dp, bottom = 8.dp)
    }
}

val WorkCardImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .objectFit(ObjectFit.Cover)
            .aspectRatio(3, 2)
    }
}

val WorkCardTagTextStyle = CssStyle {
    base {
        typography
            .bodyMedium
            .toModifier()
            .textTransform(TextTransform.Uppercase)
    }
}

@Composable
fun WorkCard(
    image: String,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tags: List<String> = emptyList(),
) {
    Column(
        modifier = WorkCardStyle
            .toModifier()
            .then(modifier)
            .onClick { onClick() },
    ) {
        Image(
            src = image,
            modifier = WorkCardImageStyle.toModifier(),
        )
        if (tags.isNotEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = WorkCardTagContainerStyle.toModifier(),
            ) {
                tags.forEachIndexed { index, tag ->
                    if (index > 0) {
                        Circle(modifier = Modifier.size(12.dp))
                    }
                    Text(
                        text = tag,
                        modifier = WorkCardTagTextStyle.toModifier(),
                    )
                }
            }
        }
        Text(
            text = title,
            modifier = WorkCardTitleStyle.toModifier(),
        )
    }
}
