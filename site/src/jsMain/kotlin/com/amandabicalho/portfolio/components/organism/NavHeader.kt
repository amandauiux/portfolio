package com.amandabicalho.portfolio.components.organism

import Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.amandabicalho.portfolio.core.ui.theme.FULL_SCREEN_MENU_CLASSNAME
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.theme.typography.Regular
import com.amandabicalho.portfolio.core.ui.theme.typography.TextStyle
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
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.justifySelf
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
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

val NavHeaderMenuDesktopStyle = CssStyle {
    base {
        Modifier.display(DisplayStyle.None)
    }

    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Flex)
            .fillMaxSize()
            .flexDirection(FlexDirection.Row)
            .alignItems(AlignItems.Center)
            .justifySelf(JustifySelf.Center)
    }
}

val NavHeaderMenuMobileStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .fillMaxSize()
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.Center)
            .justifySelf(JustifySelf.Center)
            .justifyContent(JustifyContent.Center)
    }

    Breakpoint.MD {
        Modifier.display(DisplayStyle.None)
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
        DesktopMenu(
            isDark = isDark,
            onLogoClick = onLogoClick,
            onProjectsClick = onProjectsClick,
            onAboutClick = onAboutClick,
            onThemeToggleClick = onThemeToggleClick
        )

        MobileMenu(
            onProjectsClick = onProjectsClick,
            onAboutClick = onAboutClick,
        )
    }
}

@Composable
private fun DesktopMenu(
    isDark: Boolean,
    onLogoClick: () -> Unit,
    onProjectsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onThemeToggleClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = NavHeaderDesktopStyle.toModifier().then(modifier),
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
            MenuNavigation(
                onProjectsClick = onProjectsClick,
                onAboutClick = onAboutClick,
                modifier = NavHeaderMenuDesktopStyle.toModifier(),
                style = Theme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
            )

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
}

@Composable
private fun MobileMenu(
    onProjectsClick: () -> Unit,
    onAboutClick: () -> Unit,
) {
    var isMenuOpen by remember { mutableStateOf(false) }

    IconButton(
        onClick = { isMenuOpen = true },
        icon = { Menu(modifier = Modifier.size(40.dp)) },
        modifier = NavHeaderMenuButtonStyle.toModifier(),
    )
    if (isMenuOpen) {
        Overlay(
            modifier = Modifier
                .classNames(FULL_SCREEN_MENU_CLASSNAME)
                .zIndex(1000),
        ) {
            AppNavigationDialog(
                onDismiss = { isMenuOpen = false },
            ) {
                MenuNavigation(
                    onProjectsClick = {
                        isMenuOpen = false
                        onProjectsClick()
                    },
                    onAboutClick = {
                        isMenuOpen = false
                        onAboutClick()
                    },
                    modifier = NavHeaderMenuMobileStyle
                        .toModifier()
                        .weight(1),
                    style = Theme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Regular,
                    )
                )
            }
        }
    }
}

@Composable
private fun MenuNavigation(
    style: TextStyle,
    onProjectsClick: () -> Unit,
    onAboutClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Nav(attrs = modifier.toAttrs()) {
        NavTextButton(
            text = Res.string.projects,
            style = style,
            onClick = onProjectsClick,
            modifier = Modifier.alignSelf(AlignSelf.Center),
        )
        NavTextButton(
            text = Res.string.about,
            style = style,
            onClick = onAboutClick,
            modifier = Modifier.alignSelf(AlignSelf.Center),
        )
    }
}

@Composable
private fun NavTextButton(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = style,
        )
    }
}
