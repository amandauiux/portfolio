package com.amandabicalho.portfolio.components.template.about

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.WorkExperienceCard
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.WorkExperience
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val AboutWorkExperienceStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(12) {
                    size(1.fr)
                }
            }
            .gap(24.dp)
    }
}

val AboutWorkExperienceListStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .fillMaxWidth()
            .gridColumn(start = 7, end = 13)
            .gap(40.dp)
    }
}

@Composable
fun AboutWorkExperience(
    experiences: List<WorkExperience>,
    onViewResumeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Section(
        attrs = AboutWorkExperienceStyle
            .toModifier()
            .then(modifier)
            .toAttrs(),
    ) {
        Column(
            modifier = Modifier.gridColumn(start = 1, end = 6),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Work Experience",
                style = Theme.typography.headlineSmall,
            )
            OutlinedButton(
                onClick = onViewResumeClick,
            ) {
                Text(
                    text = "View Resume",
                    style = Theme.typography.bodySmall,
                )
            }
        }
        Section(
            attrs = AboutWorkExperienceListStyle.toAttrs(),
        ) {
            experiences.forEach { experience ->
                WorkExperienceCard(experience)
            }
        }
    }
}
