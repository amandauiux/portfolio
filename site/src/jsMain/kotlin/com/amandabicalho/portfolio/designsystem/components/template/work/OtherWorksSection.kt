package com.amandabicalho.portfolio.designsystem.components.template.work

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.designsystem.components.molecule.WorkCard
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
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
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

val OtherWorksSectionGridStyle = CssStyle {
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
    }
    Breakpoint.MD {
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

val OtherWorksCardStyle = CssStyle {
    base {
        Modifier
            .flexWrap(FlexWrap.Nowrap)
            .overflow(Overflow.Hidden)
    }

//    Breakpoint.MD {
//        Modifier.gridColumn("span ${GridDefaults.DESKTOP_AREA_SIZE / 3}")
//    }

    cssRule("> img") {
        Modifier.aspectRatio(1)
    }
}

@Composable
fun OtherWorksSection(
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
                text = "Other works",
                style = Theme.typography.headlineMedium,
            )
            Section(
                attrs = OtherWorksSectionGridStyle.toAttrs(),
            ) {
                repeat(10) {
                    WorkCard(
                        image = "https://picsum.photos/400/300?random=${it + 4}", // Different placeholders
                        title = "Case study title lorem ipsum dolor with maximum two lines of text",
                        onClick = {},
                        tags = listOf("Branding", "Product Design"),
                        modifier = OtherWorksCardStyle.toModifier(),
                    )
                }
            }
        }
    }
}
