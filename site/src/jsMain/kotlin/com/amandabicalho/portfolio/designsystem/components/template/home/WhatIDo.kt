package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.designsystem.components.molecule.ServiceCard
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val WhatIDoStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(2) {
                    size(1.fr)
                }
            }
            .rowGap(80.dp)
            .justifyContent(JustifyContent.SpaceBetween)
    }
}

@Composable
fun WhatIDo(modifier: Modifier) {
    Section(
        attrs = WhatIDoStyle
            .toModifier()
            .then(modifier)
            .toAttrs()
    ) {
        Text(
            text = "What I do",
            style = Theme.typography.headlineMedium,
        )
        Text(
            text = "[services] Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed. Cursus orci adipiscing id scelerisque ipsum. Nunc viverra feugiat nunc volutpat lobortis sed. Integer ac fringilla nunc egestas.",
            style = Theme.typography.bodyLarge,
            modifier = Modifier.padding(start = 12.dp),
        )
        Row(
            modifier = Modifier
                .gridColumn(start = 1, end = 3),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            ServiceCard(
                title = "User interface",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_ui.svg",
                imageDescription = "User interface icon",
            )
            ServiceCard(
                title = "User experience",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_user_experience.svg",
                imageDescription = "User experience icon",
            )
            ServiceCard(
                title = "Product",
                description = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed.",
                imageUrl = "images/ic_product.svg",
                imageDescription = "Product icon",
            )
        }
    }
}
