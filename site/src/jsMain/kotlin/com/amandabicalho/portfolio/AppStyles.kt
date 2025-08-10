package com.amandabicalho.portfolio

import com.amandabicalho.portfolio.core.designsystem.components.atom.button.SwitchButtonVars
import com.amandabicalho.portfolio.core.extensions.margin
import com.amandabicalho.portfolio.core.ui.theme.color.Transparent
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.DefaultFontSize
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.amandabicalho.portfolio.ui.theme.DarkColorScheme
import com.amandabicalho.portfolio.ui.theme.LightColorScheme
import com.amandabicalho.portfolio.ui.theme.Typography
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.content
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.silk.components.forms.SwitchThumbStyle
import com.varabyte.kobweb.silk.components.forms.SwitchTrackStyle
import com.varabyte.kobweb.silk.components.forms.SwitchVars
import com.varabyte.kobweb.silk.components.layout.HorizontalDividerStyle
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.navigation.LinkVars
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.CssStyleScopeBase
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.after
import com.varabyte.kobweb.silk.style.vars.color.BackgroundColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.modifyStyle
import com.varabyte.kobweb.silk.theme.modifyStyleBase
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StylePropertyValue
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@InitSilk
fun initSiteStyles(context: InitSilkContext) {
    context.stylesheet.apply {
        registerStyle("html") {
            cssRule(CSSMediaQuery.MediaFeature("prefers-reduced-motion", StylePropertyValue("no-preference"))) {
                Modifier.scrollBehavior(ScrollBehavior.Smooth)
            }
        }

        layer("reset") {
            registerStyleBase("*") {
                Modifier
                    .margin(all = 0.dp)
                    .padding(all = 0.dp)
                    .outline(0.dp)
                    .boxSizing(BoxSizing.BorderBox)
            }
        }

        layer("base") {
            registerStyleBase(":root") {
                Modifier.fontSize(DefaultFontSize.px)
            }
            registerStyle("body") {
                base {
                    Typography.bodyLarge
                        .toModifier()
                        .fillMaxSize()
                        .backgroundColor(BackgroundColorVar.value())
                }
                Breakpoint.MD {
                    Typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        lineHeight = 27.sp,
                    ).toModifier()
                }
            }
            registerStyle("h1") {
                base {
                    Typography.headlineLarge.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.headlineLarge.copy(
                        fontSize = 96.sp,
                        lineHeight = 115.2.sp,
                    ).toModifier()
                }
            }
            registerStyle("h2") {
                base {
                    Typography.headlineMedium.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.headlineMedium.copy(
                        fontSize = 80.sp,
                        lineHeight = 96.sp,
                    ).toModifier()
                }
            }
            registerStyle("h3") {
                base {
                    Typography.headlineSmall.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.headlineSmall.copy(
                        fontSize = 60.sp,
                        lineHeight = 72.sp,
                    ).toModifier()
                }
            }
            registerStyle("h4") {
                base {
                    Typography.titleLarge.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.titleLarge.copy(
                        fontSize = 36.sp,
                        lineHeight = 46.8.sp,
                    ).toModifier()
                }
            }
            registerStyle("h5") {
                base {
                    Typography.titleMedium.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.titleMedium.copy(
                        fontSize = 32.sp,
                        lineHeight = 41.6.sp,
                    ).toModifier()
                }
            }
            registerStyle("h6") {
                base {
                    Typography.titleSmall.toModifier().margin(all = 0.dp) // Mobile-first
                }
                Breakpoint.MD {
                    Typography.titleSmall.copy(
                        fontSize = 24.sp,
                        lineHeight = 31.2.sp,
                    ).toModifier()
                }
            }
        }
    }

    // Silk dividers only extend 90% by default; we want full width dividers in our site
    context.theme.modifyStyleBase(HorizontalDividerStyle) {
        Modifier.fillMaxWidth()
    }

    context.theme.modifyStyleBase(SwitchTrackStyle) {
        Modifier
            .setVariable(SwitchVars.TrackBackgroundColor, Color.Transparent)
            .backgroundColor(Color.Transparent)
            .border {
                width(1.dp)
                color(colorScheme.black)
                style(LineStyle.Solid)
            }
            .padding(0.dp)
    }

    context.theme.modifyStyle(SwitchThumbStyle) {
        base {
            Modifier
                .margin(horizontal = 2.5.dp, vertical = 1.89.dp)
                .size(22.dp)
                .backgroundColor(colorScheme.primary[10])
                .borderRadius(100.percent)
                .translateX(SwitchButtonVars.ThumbOffset.value())
        }
        after {
            Modifier
                .content(" ")
                .display(DisplayStyle.Block)
                .size(20.dp)
                .border {
                    width(1.dp)
                    color(colorScheme.black)
                    style(LineStyle.Solid)
                }
                .borderRadius(100.percent)
                .transform {
                    translate(
                        tx = SwitchButtonVars.ThumbOutlineTranslationX.value(),
                        ty = SwitchButtonVars.ThumbOutlineTranslationY.value(),
                    )
                }
        }
    }

    context.theme.modifyStyleBase(LinkStyle) {
        Modifier
            .setVariable(LinkVars.DefaultColor, colorScheme.primary[30])
            .setVariable(LinkVars.VisitedColor, colorScheme.primary[30])
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
