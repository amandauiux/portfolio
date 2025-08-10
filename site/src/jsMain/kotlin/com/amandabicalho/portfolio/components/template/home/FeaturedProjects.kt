package com.amandabicalho.portfolio.components.template.home

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.WorkCard
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridVars
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.Project
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.gridArea
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnEnd
import com.varabyte.kobweb.compose.ui.modifiers.gridColumnStart
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val FeaturedProjectsStyle = CssStyle {
    base {
        Modifier.setVariable(GridVars.RowGap, 12.dp)
    }
    Breakpoint.MD {
        Modifier.setVariable(GridVars.RowGap, 80.dp)
    }
}

val FeaturedProjectsTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn("span ${GridDefaults.MOBILE_AREA_SIZE}")
    }
    Breakpoint.MD {
        Modifier
            .whiteSpace(WhiteSpace.PreWrap)
            .gridArea(GridDefaults.LEFT_AREA)
    }
}
val FeaturedProjectsDescriptionStyle = CssStyle {
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
            .cursor(Cursor.Pointer)
    }
    Breakpoint.MD {
        Modifier
            .gridColumn("span ${GridDefaults.DESKTOP_AREA_SIZE / 2}")
    }
}

@Composable
fun FeaturedProjects(
    projects: List<Project>,
    onProjectClick: (Project) -> Unit,
    onViewAllProjectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    GridSection(
        modifier = FeaturedProjectsStyle.toModifier().then(modifier),
    ) {
        Text(
            text = Res.string.featured_projects_title,
            style = Theme.typography.headlineMedium,
            modifier = FeaturedProjectsTitleStyle.toModifier(),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = FeaturedProjectsDescriptionStyle.toModifier(),
        ) {
            Text(
                text = Res.string.featured_projects_description,
                style = Theme.typography.bodyLarge,
            )

            OutlinedButton(
                onClick = onViewAllProjectClick,
            ) {
                Text(
                    text = Res.string.view_all_projects,
                    style = Theme.typography.bodySmall,
                )
            }
        }

        GridSection(modifier = FeatureWorkCardSectionStyle.toModifier()) {
            projects.forEach { project ->
                WorkCard(
                    image = project.image,
                    title = project.title,
                    onClick = { onProjectClick(project) },
                    tags = project.tags,
                    modifier = FeatureWorkCardStyle.toModifier(),
                )
            }
        }
    }
}
