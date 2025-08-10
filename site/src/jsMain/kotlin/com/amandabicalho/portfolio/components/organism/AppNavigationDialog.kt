package com.amandabicalho.portfolio.components.organism

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.IconButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Close
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignSelf

val AppNavigationDialogStyle = CssStyle.base {
    Modifier
        .fillMaxSize()
        .backgroundColor(colorScheme.background)
        .padding(24.dp)
}

@Composable
fun AppNavigationDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Column(
        modifier = AppNavigationDialogStyle.toModifier() then modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            onClick = onDismiss,
            modifier = Modifier
                .alignSelf(AlignSelf.End)
                .height(56.dp),
        ) {
            Close(
                modifier = Modifier.size(48.dp),
            )
        }
        Spacer()
        content()
        Spacer()
    }
}
