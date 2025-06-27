package com.amandabicalho.portfolio

import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.DefaultFontSize
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.ui.theme.DarkColorScheme
import com.amandabicalho.portfolio.ui.theme.LightColorScheme
import com.amandabicalho.portfolio.ui.theme.Typography
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.silk.components.layout.HorizontalDividerStyle
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyleScopeBase
import com.varabyte.kobweb.silk.style.vars.color.BackgroundColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.modifyStyleBase
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.px

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    // This site does not need scrolling itself, but this is a good demonstration for how you might enable this in your
    // own site. Note that we only enable smooth scrolling unless the user has requested reduced motion, which is
    // considered a best practice.
    ctx.stylesheet.apply {
        registerStyle("html") {
            cssRule(CSSMediaQuery.MediaFeature("prefers-reduced-motion", StylePropertyValue("no-preference"))) {
                Modifier.scrollBehavior(ScrollBehavior.Smooth)
            }
        }

        layer("reset") {
            registerStyleBase("*") {
                Modifier
                    .margin(0.dp)
                    .padding(0.dp)
                    .outline(0.dp)
                    .boxSizing(BoxSizing.BorderBox)
            }
        }

        layer("base") {
            registerStyleBase(":root") {
                Modifier.fontSize(DefaultFontSize.px)
            }
            registerStyleBase("body") {
                Typography.bodyLarge
                    .copy(lineHeight = null)
                    .toModifier()
                    .fillMaxSize()
                    .backgroundColor(BackgroundColorVar.value())
            }
        }
    }

    // Silk dividers only extend 90% by default; we want full width dividers in our site
    ctx.theme.modifyStyleBase(HorizontalDividerStyle) {
        Modifier.fillMaxWidth()
    }
}

/**
 * Workaround to enable [com.varabyte.kobweb.silk.components.style.ComponentStyle]
 * to use [Theme.colorScheme].
 */
val CssStyleScopeBase.colorScheme
    get() = if (colorMode == ColorMode.DARK) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

/**
 * Workaround to enable [CssStyleScopeBase]
 * to use [Theme.typography].
 */
val CssStyleScopeBase.typography
    get() = Typography
