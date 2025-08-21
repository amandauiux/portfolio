package com.amandabicalho.portfolio.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.core.ui.theme.color.copy
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.percent

val ShowcaseSmallCardStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(all = 32.dp)
            .background(color = colorScheme.gray.copy(alpha = 0.5f))
            .borderRadius(20.dp)
    }
    Breakpoint.LG {
        Modifier
            .flexGrow(1)
            .flexBasis(48.percent)
    }
}

@Composable
fun ShowcaseSmallCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = ShowcaseSmallCardStyle.toModifier().then(modifier)) {
        content()
    }
}
