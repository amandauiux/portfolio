package com.amandabicalho.portfolio.core.designsystem.components.atom.button

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover

val TextButtonVariant = ButtonStyle.addVariant {
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
fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        elevation = null,
        contentPadding = contentPadding,
        variant = TextButtonVariant,
        content = content,
    )
}
