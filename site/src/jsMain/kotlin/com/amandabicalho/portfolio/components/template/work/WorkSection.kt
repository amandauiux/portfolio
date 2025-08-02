package com.amandabicalho.portfolio.components.template.work

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.molecule.WorkCard
import com.amandabicalho.portfolio.core.ui.unit.dp
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

val WorkSectionGridStyle = CssStyle {
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
fun WorkSection(
    modifier: Modifier = Modifier,
) {
    Section(
        attrs = modifier.toAttrs()
    ) {
        Column(
            modifier = WorkSectionGridStyle.toModifier()
        ) {
            // 4 WorkCards for the "Work" section
            repeat(4) {
                WorkCard(
                    image = "https://picsum.photos/858/416?random=$it", // Placeholder
                    title = "Case study title lorem ipsum dolor with maximum two lines of text",
                    onClick = {},
                    tags = listOf("Web Design", "UI/UX")
                )
            }
        }
    }
}
