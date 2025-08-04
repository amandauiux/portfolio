package com.amandabicalho.portfolio.core.designsystem.components.atom.content

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.amandabicalho.portfolio.core.foundation.layout.calculateHorizontalPadding
import com.amandabicalho.portfolio.core.foundation.layout.calculateVerticalPadding
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Section

val GridSectionStyle = GridStyle.addVariant {
    base {
        Modifier
    }
    Breakpoint.MD {
        Modifier
    }
}

@Composable
fun GridSection(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues? = null,
    content: @Composable () -> Unit,
) {
    Section(
        attrs = GridStyle
            .toModifier(GridSectionStyle)
            .then(modifier)
            .thenIf(contentPadding != null) {
                requireNotNull(contentPadding)
                Modifier
                    .setVariable(GridVars.RowGap, contentPadding.calculateVerticalPadding())
                    .setVariable(GridVars.ColumnGap, contentPadding.calculateHorizontalPadding())
            }
            .toAttrs(),
    ) {
        content()
    }
}
