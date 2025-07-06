package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSectionDefaults
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
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnEnd
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnStart
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr

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

val FeatureWorkCardSectionStyle = CssStyle {
    base {
        Modifier
            .gridColumnStart(GridSectionDefaults.LEFT_AREA)
            .gridColumnEnd(GridSectionDefaults.RIGHT_AREA)
            .rowGap(80.dp)
    }
}

val FeatureWorkCardStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridSectionDefaults.DESKTOP_AREA_SIZE / 2}")
    }

    Breakpoint.MD {
        Modifier
            .gridColumn("span ${GridSectionDefaults.DESKTOP_AREA_SIZE / 2}")
    }
}

@Composable
fun FeaturedWork(
    onViewAllProjectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    GridSection(
        modifier = FeaturedWorkStyle.toModifier().then(modifier),
    ) {
        Text(
            text = "Featured Work",
            style = Theme.typography.headlineMedium,
            modifier = Modifier.gridArea(GridSectionDefaults.LEFT_AREA),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.gridArea(GridSectionDefaults.RIGHT_AREA),
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

        GridSection(modifier = FeatureWorkCardSectionStyle.toModifier()) {
            repeat(4) { index ->
                WorkCard(
                    image = "https://picsum.photos/858/416",
                    title = "Case study title lorem ipsum dolor with maximum two lines of text",
                    onClick = {},
                    tags = listOf(
                        "Web Design",
                        "UI/UX",
                        "Branding",
                    ),
                    modifier = FeatureWorkCardStyle.toModifier(),
                )
            }
        }
    }
}
