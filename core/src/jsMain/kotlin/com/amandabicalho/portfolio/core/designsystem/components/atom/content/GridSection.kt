package com.amandabicalho.portfolio.core.designsystem.components.atom.content

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.amandabicalho.portfolio.core.foundation.layout.calculateHorizontalPadding
import com.amandabicalho.portfolio.core.foundation.layout.calculateVerticalPadding
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateAreas
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Section

object GridSectionDefaults {
    const val LEFT_AREA = "l_side"
    const val RIGHT_AREA = "r_side"
    const val DESKTOP_AREA_SIZE = 12
    const val MOBILE_AREA_SIZE = 4

    val DesktopGridAreaTemplate
        get() = calculateGridTemplateAreas(areaSize = DESKTOP_AREA_SIZE)

    val MobileGridAreaTemplate
        get() = calculateGridTemplateAreas(areaSize = MOBILE_AREA_SIZE)

    private fun calculateGridTemplateAreas(areaSize: Int): String {
        return "$LEFT_AREA ".repeat(areaSize / 2) +
            "$RIGHT_AREA ".repeat(areaSize / 2).trim()
    }
}

object GridSectionVars {
    val RowGap by StyleVariable<Dp>()
    val ColumnGap by StyleVariable<Dp>()
}

val GridSectionStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(GridSectionDefaults.MOBILE_AREA_SIZE) {
                    size(1.fr)
                }
            }
            .gridTemplateAreas(GridSectionDefaults.MobileGridAreaTemplate)
            .gap(
                rowGap = GridSectionVars.RowGap.value(40.dp),
                columnGap = GridSectionVars.ColumnGap.value(16.dp)
            )
    }
    Breakpoint.MD {
        Modifier
            .gridTemplateColumns {
                repeat(GridSectionDefaults.DESKTOP_AREA_SIZE) {
                    size(1.fr)
                }
            }
            .gridTemplateAreas(GridSectionDefaults.DesktopGridAreaTemplate)
            .gap(
                rowGap = GridSectionVars.RowGap.value(80.dp),
                columnGap = GridSectionVars.ColumnGap.value(24.dp)
            )
    }
}

@Composable
fun GridSection(
    modifier: Modifier = Modifier,
    useHeader: Boolean = false,
    contentPadding: PaddingValues? = null,
    content: @Composable () -> Unit,
) {
    val modifier = GridSectionStyle
        .toModifier()
        .then(modifier)
        .thenIf(contentPadding != null) {
            requireNotNull(contentPadding)
            Modifier
                .setVariable(GridSectionVars.RowGap, contentPadding.calculateVerticalPadding())
                .setVariable(GridSectionVars.ColumnGap, contentPadding.calculateHorizontalPadding())
        }
    if (useHeader) {
        Header(
            attrs = modifier.toAttrs(),
        ) {
            content()
        }
    } else {
        Section(
            attrs = modifier.toAttrs(),
        ) {
            content()
        }
    }
}
