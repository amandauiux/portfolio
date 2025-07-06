package com.amandabicalho.portfolio.designsystem.components.molecule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.domain.WorkExperience
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.web.css.LineStyle

val WorkExperienceCardStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .gap(16.dp)
            .border {
                width(1.dp)
                color(colorScheme.gray)
                style(LineStyle.Solid)
            }
            .borderRadius(12.dp)
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
    Row(
        modifier = WorkExperienceCardStyle.toModifier().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = experience.title,
                style = Theme.typography.titleSmall,
            )
            Text(
                text = experience.description,
                style = Theme.typography.bodyMedium,
            )
        }

        val period = remember(experience) {
            buildString {
                append(formatter.format(experience.startDate))
                append(" - ")
                append(experience.endDate?.let(formatter::format) ?: "Present")
            }
        }

        Text(
            text = period,
            style = Theme.typography.bodyMedium,
        )
    }
}
