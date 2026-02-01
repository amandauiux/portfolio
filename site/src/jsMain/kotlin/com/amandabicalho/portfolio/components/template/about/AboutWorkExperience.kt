package com.amandabicalho.portfolio.components.template.about

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.components.molecule.WorkExperienceCard
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.OutlinedButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.WorkExperience
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.Section

val AboutWorkExperienceStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(20.dp)
    }
}

val AboutWorkExperienceTitleStyle = CssStyle {
    base {
        Modifier.gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
    Breakpoint.LG {
        Modifier.gridColumn(GridDefaults.LEFT_AREA)
    }

    cssRule("> button") {
        Modifier.display(DisplayStyle.None)
    }

    cssRule(Breakpoint.LG, "> button") {
        Modifier.display(DisplayStyle.Block)
    }
}

val AboutWorkExperienceListStyle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .fillMaxWidth()
            .gap(20.dp)
    }
    Breakpoint.LG {
        Modifier
            .gridColumn(GridDefaults.RIGHT_AREA)
            .gap(40.dp)
    }

    cssRule("> button") {
        Modifier.display(DisplayStyle.Block)
    }

    cssRule(Breakpoint.LG, "> button") {
        Modifier
            .display(DisplayStyle.None)
    }
}

@Composable
fun AboutWorkExperience(
    experiences: List<WorkExperience>,
    modifier: Modifier = Modifier,
) {
    GridSection(
        modifier = AboutWorkExperienceStyle
            .toModifier()
            .then(modifier),
    ) {
        Column(
            modifier = AboutWorkExperienceTitleStyle.toModifier(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = Res.string.about_work_experience,
                style = Theme.typography.headlineSmall,
            )
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
