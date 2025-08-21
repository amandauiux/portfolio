package com.amandabicalho.portfolio.components.template.project

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.ProjectCard
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.Project
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridAutoColumns
import com.varabyte.kobweb.compose.ui.modifiers.gridAutoFlow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.GridAutoFlow
import org.jetbrains.compose.web.css.div
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Section

private const val VisibleColumns = 3
private val ColumnGap = 24.dp

val OtherProjectsSectionGridStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gridAutoFlow(GridAutoFlow.Column)
            .gridTemplateRows {
                size(100.percent - ColumnGap - 25.percent)
            }
            .gridAutoColumns {
                size(100.percent - ColumnGap - 25.percent)
            }
            .overflow {
                x(Overflow.Auto)
                y(Overflow.Hidden)
            }
            .gap(ColumnGap)
            .styleModifier {
                property("-webkit-overflow-scrolling", "touch") // Enable smooth scrolling on iOS
            }
    }
    Breakpoint.LG {
        Modifier
            .display(DisplayStyle.Grid)
            .gridAutoFlow(GridAutoFlow.Column)
            .gridTemplateRows {
                size(((100.percent) / VisibleColumns) - ColumnGap - 25.percent / VisibleColumns)
            }
            .gridAutoColumns {
                size(((100.percent) / VisibleColumns) - ColumnGap - 25.percent / VisibleColumns)
            }
            .overflow {
                x(Overflow.Auto)
                y(Overflow.Hidden)
            }
            .gap(ColumnGap)
            .padding(bottom = 24.dp)
    }
}

val OtherProjectsCardStyle = CssStyle {
    base {
        Modifier
            .flexWrap(FlexWrap.Nowrap)
            .overflow(Overflow.Hidden)
    }

//    Breakpoint.LG {
//        Modifier.gridColumn("span ${GridDefaults.DESKTOP_AREA_SIZE / 3}")
//    }

    cssRule("> img") {
        Modifier
            .aspectRatio(1)
            .objectFit(ObjectFit.Cover)
    }
}

@Composable
fun OtherProjectsSection(
    projects: List<Project>,
    onProjectClick: (Project) -> Unit,
    modifier: Modifier = Modifier,
) {
    Section(
        attrs = modifier.toAttrs(),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Text(
                text = Res.string.other_projects,
                style = Theme.typography.headlineMedium,
            )
            Section(
                attrs = OtherProjectsSectionGridStyle.toAttrs(),
            ) {
                projects.forEach { project ->
                    ProjectCard(
                        image = project.image,
                        title = project.title,
                        onClick = { onProjectClick(project) },
                        tags = project.tags,
                        modifier = OtherProjectsCardStyle.toModifier(),
                    )
                }
            }
        }
    }
}
