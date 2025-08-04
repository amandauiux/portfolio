package com.amandabicalho.portfolio.core.designsystem.components.atom.content

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateAreas
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Div

object GridDefaults {
    const val LEFT_AREA = "l_side"
    const val RIGHT_AREA = "r_side"
    const val DESKTOP_AREA_SIZE = 12
    const val MOBILE_AREA_SIZE = 4

    val DesktopGridAreaTemplate
        get() = calculateGridTemplateAreas(areaSize = DESKTOP_AREA_SIZE)

    val MobileGridAreaTemplate
        get() = calculateGridTemplateAreas(areaSize = MOBILE_AREA_SIZE)

    fun calculateGridTemplateAreas(areaSize: Int): String {
        return "$LEFT_AREA ".repeat(areaSize / 2) +
            "$RIGHT_AREA ".repeat(areaSize / 2).trim()
    }
}

object GridVars {
    val RowGap by StyleVariable<Dp>()
    val ColumnGap by StyleVariable<Dp>()
}

sealed interface GridKind : ComponentKind

val GridStyle = CssStyle<GridKind> {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(GridDefaults.MOBILE_AREA_SIZE) {
                    size(1.fr)
                }
            }
            .gridTemplateAreas(GridDefaults.MobileGridAreaTemplate)
            .gap(
                rowGap = GridVars.RowGap.value(40.dp),
                columnGap = GridVars.ColumnGap.value(16.dp)
            )
    }
    Breakpoint.MD {
        Modifier.desktopGrid()
    }
}

fun Modifier.desktopGrid(): Modifier = this then Modifier
    .display(DisplayStyle.Grid)
    .gridTemplateColumns {
        repeat(GridDefaults.DESKTOP_AREA_SIZE) {
            size(1.fr)
        }
    }
    .gridTemplateAreas(GridDefaults.DesktopGridAreaTemplate)
    .gap(
        rowGap = GridVars.RowGap.value(80.dp),
        columnGap = GridVars.ColumnGap.value(24.dp)
    )

@Composable
fun Grid(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Div(
        attrs = GridStyle
            .toModifier()
            .then(modifier)
            .toAttrs(),
    ) {
        content()
    }
}
