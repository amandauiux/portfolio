package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.designsystem.components.molecule.WorkCard
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val FeaturedWorkStyle = CssStyle {
    base {
        // grid of 2 columns, with 24.dp gap between columns and 80.dp gap between rows
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(2) {
                    size(1.fr)
                }
            }
            .gap(columnGap = 24.dp, rowGap = 80.dp)
            .fillMaxWidth()
    }
}

@Composable
fun FeaturedWork(
    onViewAllProjectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Section(attrs = FeaturedWorkStyle.toModifier().then(modifier).toAttrs()) {
        Text(
            text = "Featured Work",
            style = Theme.typography.headlineMedium,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed. Cursus orci adipiscing id scelerisque ipsum. Nunc viverra feugiat nunc volutpat lobortis sed. Integer ac fringilla nunc egestas.",
                style = Theme.typography.bodyLarge,
            )

            OutlinedButton(
                onClick = onViewAllProjectClick,
            ) {
                Text(text = "View all projects")
            }
        }

        repeat(4) {
            WorkCard(
                image = "https://picsum.photos/858/416",
                title = "Case study title lorem ipsum dolor with maximum two lines of text",
                onClick = {},
                tags = listOf(
                    "Web Design",
                    "UI/UX",
                    "Branding",
                ),
            )
        }
    }
}
