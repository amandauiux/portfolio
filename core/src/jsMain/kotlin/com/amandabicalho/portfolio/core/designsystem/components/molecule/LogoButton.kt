package com.amandabicalho.portfolio.core.designsystem.components.molecule

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Logo
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.navigation.Link

@Composable
fun LogoButton(
    modifier: Modifier = Modifier,
) {
    Link(
        path = "https://amandabicalho.dev",
        modifier = modifier,
    ) {
        Logo()
    }
}
