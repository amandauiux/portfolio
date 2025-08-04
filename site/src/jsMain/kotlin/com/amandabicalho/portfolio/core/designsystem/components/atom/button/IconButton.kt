package com.amandabicalho.portfolio.core.designsystem.components.atom.button

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover

val IconButtonVariant = ButtonStyle.addVariant {
    base {
        Modifier.backgroundColor(Colors.Transparent)
    }
    hover {
        Modifier.backgroundColor(
            ButtonDefaults.Vars.ContainerColor.value()
        )
    }
}

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.iconButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.IconButtonContentPadding,
    icon: @Composable () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        elevation = null,
        contentPadding = contentPadding,
        variant = IconButtonVariant,
        content = {
            icon()
        },
    )
}
