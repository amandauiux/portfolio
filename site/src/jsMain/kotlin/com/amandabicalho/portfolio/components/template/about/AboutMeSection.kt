package com.amandabicalho.portfolio.components.template.about

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Paragraph
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.extensions.margin
import com.amandabicalho.portfolio.core.featureflag.FeatureFlag
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier

val AboutMeSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(40.dp)
    }
    Breakpoint.MD {
        Modifier.gap(80.dp)
    }
}

val AboutMeMyJourneyTitle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
    Breakpoint.MD {
        Modifier
            .gridColumn(GridDefaults.LEFT_AREA)
    }
}
val AboutMeMyJourneyContent = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .gap(12.dp)
    }
    Breakpoint.MD {
        Modifier
            .gridColumn(GridDefaults.RIGHT_AREA)
            .gap(20.dp)
    }
}

val AboutMeImageGridStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
    }
}

val AboutMeImageBaseStyle = CssStyle {
    base {
        Modifier
            .height(362.dp)
            .backgroundColor(colorScheme.gray)
    }
    cssRule(":nth-child(odd)") {
        Modifier.margin(vertical = 40.dp)
    }
    cssRule(":nth-child(even)") {
        Modifier.margin(top = 80.dp)
    }
}

@Composable
fun AboutMeSection(modifier: Modifier = Modifier) {
    Column(
        modifier = AboutMeSectionStyle
            .toModifier()
            .then(modifier),
    ) {
        GridSection {
            Text(
                text = Res.string.about_my_journey,
                style = Theme.typography.headlineSmall,
                modifier = AboutMeMyJourneyTitle.toModifier(),
            )
            Column(
                modifier = AboutMeMyJourneyContent.toModifier(),
            ) {
                Paragraph(
                    text = Res.string.about_my_journey_paragraph_1,
                    style = Theme.typography.bodyLarge,
                )
                Paragraph(
                    text = Res.string.about_my_journey_paragraph_2,
                    style = Theme.typography.bodyLarge,
                )
            }
        }

        if (FeatureFlag.ShowAboutMyselfSection.enabled) {
            // Image Grid Section
            Row(
                modifier = AboutMeImageGridStyle.toModifier(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                repeat(4) { index ->
                    Box(
                        modifier = AboutMeImageBaseStyle
                            .toModifier()
                            .weight(1f),
                    )
                }
            }
        }
    }
}
