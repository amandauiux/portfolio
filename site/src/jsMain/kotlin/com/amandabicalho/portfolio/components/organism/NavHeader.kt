package com.amandabicalho.portfolio.components.organism

import Res
import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.IconButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.SwitchButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.TextButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Menu
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Moon
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Sun
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.featureflag.FeatureFlag
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.typography
import com.amandabicalho.portfolio.ui.theme.ArchivoNarrow
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.JustifySelf
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifySelf
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.dom.Nav

val NavHeaderStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 64.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
            .borderBottom {
                width(1.dp)
                color(colorScheme.primary[30])
                style(LineStyle.Solid)
            }
            .alignItems(AlignItems.Center)
    }
    Breakpoint.MD {
        Modifier
            .height(80.dp)
            .padding(start = 36.dp, end = 40.dp, top = 22.dp, bottom = 22.dp)
    }
}

val NavHeaderDesktopStyle = CssStyle {
    base {
        Modifier.display(DisplayStyle.None)
    }
    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Flex)
            .fillMaxSize()
    }
}

val NavHeaderMenuButtonStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Block)
            .alignSelf(AlignSelf.Center)
            .justifySelf(JustifySelf.End)
    }
    Breakpoint.MD {
        Modifier.display(DisplayStyle.None)
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
    onLogoClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onThemeToggleClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = NavHeaderStyle.toModifier().then(modifier),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = NavHeaderDesktopStyle.toModifier(),
        ) {
            TextButton(
                onClick = onLogoClick,
                modifier = Modifier.margin(left = (-16).dp),
            ) {
                Text(
                    text = "Amanda Bicalho",
                    modifier = NavHeaderBrandingStyle.toModifier(),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(80.dp),
            ) {
                Nav {
                    Row {
                        NavTextButton(
                            text = Res.string.projects,
                            modifier = Modifier.alignSelf(AlignSelf.Center),
                            onClick = onProjectsClick,
                        )
                        NavTextButton(
                            text = Res.string.about,
                            modifier = Modifier.alignSelf(AlignSelf.Center),
                            onClick = onAboutClick,
                        )
                    }
                }
                if (FeatureFlag.EnableLightDarkMode.enabled) {
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

        IconButton(
            onClick = {},
            icon = { Menu(modifier = Modifier.size(40.dp)) },
            modifier = NavHeaderMenuButtonStyle.toModifier(),
        )
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
