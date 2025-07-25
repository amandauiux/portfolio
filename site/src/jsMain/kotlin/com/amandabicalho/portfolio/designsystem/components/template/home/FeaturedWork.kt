package com.amandabicalho.portfolio.designsystem.components.template.home

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridVars
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.designsystem.components.molecule.WorkCard
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnEnd
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnStart
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val FeaturedWorkStyle = CssStyle {
    base {
        Modifier.setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}

val FeaturedWorkTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.LEFT_AREA)
    }
}
val FeaturedWorkDescriptionStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
            .margin(bottom = 28.dp)
    }

    Breakpoint.MD {
        Modifier
            .gridArea(GridDefaults.RIGHT_AREA)
            .margin(bottom = 0.dp)
    }
}

val FeatureWorkCardSectionStyle = CssStyle {
    base {
        Modifier
            .gridColumnStart(GridDefaults.LEFT_AREA)
            .gridColumnEnd(GridDefaults.RIGHT_AREA)
    }

    Breakpoint.MD {
        Modifier.rowGap(80.dp)
    }
}

val FeatureWorkCardStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }

    Breakpoint.MD {
        Modifier
            .gridColumn("span ${GridDefaults.DESKTOP_AREA_SIZE / 2}")
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
            modifier = FeaturedWorkTitleStyle.toModifier(),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = FeaturedWorkDescriptionStyle.toModifier(),
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet consectetur. Natoque diam at ultrices ac. Nam metus cras neque sed. Cursus orci adipiscing id scelerisque ipsum. Nunc viverra feugiat nunc volutpat lobortis sed. Integer ac fringilla nunc egestas.",
                style = Theme.typography.bodyLarge,
            )

            OutlinedButton(
                onClick = onViewAllProjectClick,
            ) {
                Text(
                    text = "View all projects",
                    style = Theme.typography.bodySmall,
                )
            }
        }

        GridSection(modifier = FeatureWorkCardSectionStyle.toModifier()) {
            repeat(4) { index ->
                WorkCard(
                    image = "https://picsum.photos/858/416?random=${index + 4}",
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
