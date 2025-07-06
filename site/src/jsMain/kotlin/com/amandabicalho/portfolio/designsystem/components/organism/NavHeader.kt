package com.amandabicalho.portfolio.designsystem.components.organism

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.SwitchButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.TextButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Moon
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Sun
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.amandabicalho.portfolio.typography
import com.amandabicalho.portfolio.ui.theme.ArchivoNarrow
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.dom.Nav

val NavHeaderStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(start = 36.dp, end = 40.dp, top = 22.dp, bottom = 22.dp)
        .borderBottom {
            width(1.dp)
            color(colorScheme.primary[30])
            style(LineStyle.Solid)
        }
}

val NavHeaderBrandingStyle = CssStyle.base {
    typography
        .titleSmall
        .copy(
            fontFamily = ArchivoNarrow,
            fontWeight = FontWeight.Bold,
        )
        .toModifier()
        .alignSelf(AlignSelf.Center)
}


@Composable
fun NavHeader(
    isDark: Boolean,
    onWorkClick: () -> Unit,
    onAboutClick: () -> Unit,
    onContactClick: () -> Unit,
    onThemeToggleClick: () -> Unit,
) {
    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Amanda Bicalho",
            modifier = NavHeaderBrandingStyle.toModifier(),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(80.dp),
        ) {
            Nav {
                Row {
                    NavTextButton(
                        text = "Work",
                        modifier = Modifier.alignSelf(AlignSelf.Center),
                        onClick = onWorkClick,
                    )
                    NavTextButton(
                        text = "About",
                        modifier = Modifier.alignSelf(AlignSelf.Center),
                        onClick = onAboutClick,
                    )
                    NavTextButton(
                        text = "Contact",
                        modifier = Modifier.alignSelf(AlignSelf.Center),
                        onClick = onContactClick,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Sun()
                SwitchButton(
                    checked = isDark,
                    onCheckChange = { onThemeToggleClick() },
                )
                Moon()
            }
        }
    }
}

@Composable
private fun NavTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = Theme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}
