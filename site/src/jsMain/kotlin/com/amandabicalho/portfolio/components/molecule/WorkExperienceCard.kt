package com.amandabicalho.portfolio.components.molecule

import Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.WorkExperience
import com.amandabicalho.portfolio.typography
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

val WorkExperienceCardStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .fillMaxWidth()
            .gap(12.dp)
            .padding(16.dp)
            .border {
                width(1.dp)
                color(colorScheme.gray)
                style(LineStyle.Solid)
            }
            .borderRadius(12.dp)
    }

    Breakpoint.LG {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .gap(16.dp)
            .justifyContent(JustifyContent.SpaceBetween)
    }
}

val WorkExperiencePeriodTextStyle = CssStyle {
    base {
        typography.bodyMedium.toModifier()
    }

    Breakpoint.LG {
        typography.bodyMedium
            .copy(textAlign = TextAlign.Right)
            .toModifier()
    }
}


private val formatter = LocalDate.Format {
    year()
}

@Composable
fun WorkExperienceCard(
    experience: WorkExperience,
    modifier: Modifier = Modifier,
) {
    Div(
        attrs = WorkExperienceCardStyle.toModifier().then(modifier).toAttrs(),
    ) {
        Column {
            Span(
                attrs = Theme.typography.titleSmall.toModifier().toAttrs(),
            ) {
                Text(value = Res.string.about_work_experience_position.format(experience.title))
                Link(
                    path = experience.url,
                    text = experience.company,
                )
            }
        }

        val period = remember(experience) {
            buildString {
                append(formatter.format(experience.startDate))
                append(" - ")
                append(experience.endDate?.let(formatter::format) ?: Res.string.about_work_current)
            }
        }

        Text(
            text = period,
            style = Theme.typography.bodyMedium,
            modifier = WorkExperiencePeriodTextStyle.toModifier(),
        )
    }
}
