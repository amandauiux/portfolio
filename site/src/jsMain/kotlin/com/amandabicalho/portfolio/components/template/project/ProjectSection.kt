package com.amandabicalho.portfolio.components.template.project

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.molecule.WorkCard
import com.amandabicalho.portfolio.components.template.home.FeatureWorkCardStyle
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.Project
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val ProjectsSectionGridStyle = CssStyle {
    base { // Mobile first: 1 column
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns { repeat(1) { size(1.fr) } }
            .rowGap(40.dp)
            .fillMaxWidth()
    }
    Breakpoint.MD { // 2 columns for medium screens and up
        Modifier
            .gridTemplateColumns { repeat(2) { size(1.fr) } }
            .gap(columnGap = 24.dp, rowGap = 80.dp)
    }
}

@Composable
fun ProjectsSection(
    projects: List<Project>,
    onProjectClick: (Project) -> Unit,
    modifier: Modifier = Modifier,
) {
    Section(
        attrs = modifier.toAttrs()
    ) {
        Column(
            modifier = ProjectsSectionGridStyle.toModifier()
        ) {
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
