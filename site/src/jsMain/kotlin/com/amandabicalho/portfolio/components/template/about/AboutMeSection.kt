package com.amandabicalho.portfolio.components.template.about

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Paragraph
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.extensions.margin
import com.amandabicalho.portfolio.core.featureflag.FeatureFlag
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Section

val AboutMeSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gap(80.dp) // Increased gap for better separation between sections
    }
}

// Style for the header section (title and description)
val AboutMeHeaderStyle = CssStyle {
    base { // Mobile: Stack title and description
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(16.dp)
    }
    Breakpoint.MD { // Desktop: Two columns grid
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(12) {
                    size(1.fr)
                }
            }
            .gap(24.dp)
            .alignItems(AlignItems.Start) // Align items to the start vertically
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
    Section(
        attrs = AboutMeSectionStyle
            .toModifier()
            .then(modifier)
            .toAttrs(),
    ) {
        // Header section (Title and Description)
        Column(modifier = AboutMeHeaderStyle.toModifier()) {
            Text(
                text = Res.string.about_my_journey,
                style = Theme.typography.headlineSmall,
                modifier = Modifier
                    .gridColumn(start = 1, end = 6)
            )
            Column(
                modifier = Modifier.gridColumn(start = 7, end = 13),
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
